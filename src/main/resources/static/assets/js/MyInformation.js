//现实右上角的信息
var my_information = new Vue({
    el:'#Myinformation',
    data:{
        name:"",
        phonenumber:"",
        idCard:"",
        sex:"",
        birth:"",
        belong:"",
        major:"",
        education:""
    },
    mounted:function (){
        this.getWorkerInformation();
    },
    methods:{
        getWorkerInformation(){
            var that = this;
            axios.get("/GlobalVariable/GetWorkerId") .then()
                .then(function (response) {

                    var workerid = response.data;

                    axios.get('/getWorkerAllInformationByID', {
                        params: {
                            workerid:workerid
                        }
                    })
                        .then(function (response) {

                            that.name = response.data.name;
                            that.phonenumber = response.data.phonenumber;
                            that.idCard = response.data.idcard;
                            that.sex = response.data.sex;
                            that.birth = response.data.birth;
                            that.belong = response.data.belong;
                            that.major = response.data.major;
                            that.education = response.data.education;
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