//现实右上角的信息
var information1 = new Vue({
    el:'#Right_up_name',
    data:{
        name:""
    },
    mounted:function (){
        this.getName();//获取当前登录者的姓名
    },
    methods:{
        getName(){
            var that = this;
            axios.get("/GlobalVariable/GetWorkerId") .then()
                .then(function (response) {

                    var workerid = response.data;

                    axios.get('/getWorkerNameByID', {
                        params: {
                            workerid:workerid
                        }
                    })
                        .then(function (response) {
                            that.name = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });

            })
                .catch(function (error) {
                    console.log(error);
                });

        }
    }

})