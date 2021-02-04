var login_ = new Vue({
    el:'#loginForm_',
    data:{
        phonenumber:"",
        password:""
    },
    methods: {
        login:function (){
            axios.get('/login', {
                params: {
                    phonenumber:this.phonenumber,
                    password:this.password
                }
            })
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})

var login = new Vue({
    el:"#loginForm",
    data:{
        show:true,
        code_time:5,
        name:"",
        phonenumber:"",
        password:"",
        passwordRepeat:"",
        check_number:"",
        hasCheckNumber:"",
        randomNumber:""
    },
    methods:{

        // handon:function(){
        //     if(this.name==""||this.phonenumber==""||this.password==""||
        //         this.passwordRepeat==""||this.check_code==""){
        //         alert("请完整填写注册信息！");
        //     }else if (this.password!=this.passwordRepeat){
        //         alert("两次密码输入不一致！");
        //     }else if()

        check_exist:function(){


        },
        time1:function (){
            this.code_time=this.code_time-1;
            console.log(this.code_time);
            if(this.code_time==0){
                clearInterval(this.time_count);
                this.time_count = null;
                this.code_time=5;
                this.show=!this.show;
            }
        },
        check_code(){

            if(this.phonenumber.length!=11){
                alert("请输入正确的电话号码！");
                this.login.phonenumber="";
            }
            var that = this;
            var x = this.phonenumber;
            var code = Math.floor(Math.random()*(9999-1000))+1000;
            that.randomNumber = code;
            //判断电话号码是否已经被注册并发送短信
            axios.get('/check_number', {
                params: {
                    phonenumber: x,
                    codenumber:code
                }
            }).then(function (response) {
                console.log(response);
                if(response.data==1){
                    alert("该手机号码已经被注册");

                }else if(response.data==2){
                    that.show=!that.show;
                    that.time_count = setInterval(that.time1,1000);
                    that.hasCheckNumber=x;



                }else{
                    alert("验证码发送失败！！");
                }
            }).catch(function (error) {
                    console.log(error);
                });



        },
        //注册按钮
        handon:function(){
            if(this.name==""||this.phonenumber==""||this.password==""||
                this.passwordRepeat==""||this.check_number==""){
                alert("请完整填写注册信息！");
            }else if (this.password!=this.passwordRepeat){
                alert("两次密码输入不一致！");
            }else if(this.hasCheckNumber!=this.phonenumber){
                alert("接受验证码的手机号与现所填号码不一致！");
            }else if(this.check_number!=this.randomNumber){
                alert("验证码不正确！");
            }else{
                axios.get('/register', {
                    params: {
                        name:this.name,
                        phonenumber:this.phonenumber,
                        password: this.password
                    }
                })
                    .then(function (response) {
                        alert("注册成功！");
                        location.reload();
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        }
    }


})