var confirmInformation = new Vue({
    el:'#page-wrapper',
    data:{
        imageUrl:"",
        finishConfirm:0

    },
    created:function (){
        this.creatPage();
    },
    methods: {
        creatPage(){
            var that = this;
            axios.get("/GlobalVariable/GetWorkerId") .then()
                .then(function (response) {

                    var workerid = response.data;

                    axios.get('/ifconfirm', {
                        params: {
                            workerId:workerid
                        }
                    })
                        .then(function (response) {
                            that.finishConfirm = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        confirm(){
            var that = this;
            var str = information1.$data.workerId;
            console.log(that.imageUrl);
            axios.post('/confirmInformation', {

                    imageBase:that.imageUrl,
                    workerId:str

            }).then(function (response) {
                    if(response.data==1){
                        alert("认证成功！");
                    }else if(response.data==0){
                        alert("认证申请发送错误！");
                    }else if(response.data==2){
                        alert("上传身份证不真实！");
                    }else if(response.data==3){
                        alert("身份证已注册！");
                    }else{
                        alert("未知错误！");
                    }

                    location.reload();
                })
                .catch(function (error) {
                    console.log(error);
                });
        },

        saveSrc(e) {
            let file = this.$refs.imgInput.files[0]
            if (file === undefined) {
                this.imageUrl = " "
                console.log("没有选择图片")
            }
            const _this = this
            let reader = new FileReader();
            reader.readAsDataURL(file); // 读出 base64
            reader.onloadend = function () {
                _this.imageUrl = reader.result;
            };
        }

    },
    watch:{
    }
})