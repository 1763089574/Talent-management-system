var companyList = new Vue({
    el:'#list',
    data:{
        companyList:[]
    },
    mounted:function (){
        this.getCompanyList();//获取当前登录者的姓名
    },
    methods:{
        getCompanyList(){
            var that = this;
            axios.get("/GlobalVariable/GetWorkerId")
                .then(function (response) {

                })
                .catch(function (error) {
                    console.log(error);
                });

        }
    }

})