var companyList = new Vue({
    el:'#list',
    data:{
        companyList:[],
        clickID:"",
        clickCompanyName:"",
        if_primary:false,
        ifbtn:true,
        ifdisplay:true
    },
    created:function (){
        this.getCompanyList();

    },
    methods: {

        getCompanyList() {
            var that = this;
            axios.get('/getAllHasIdentifyCompanies')
                .then(function (response) {
                    that.companyList = response.data;

                    //判断按钮是否可以点击
                    axios.get('/GlobalVariable/GetWorkerId')
                        .then(function (response) {
                            var workerid = response.data;

                            axios.get('/ifClickApplyButton', {
                                params: {
                                    workerid:workerid
                                }
                            })
                                .then(function (response) {
                                    if(response.data){
                                        that.if_primary=true;
                                        that.ifdisplay=false;
                                    }else{
                                        that.if_primary=false;
                                        that.ifdisplay=true;
                                    }
                                })
                                .catch(function (error) {
                                    console.log(error);
                                });
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                })
                .catch(function (error) {
                    console.log(error);
                });
        },
        getCompanyID(id,name){
            this.clickID = id;
            this.clickCompanyName = name;
        },
        sendApply(){
            var that =this;
            axios.get("/GlobalVariable/GetWorkerId") .then()
                .then(function (response) {

                    var workerid = response.data;
                    axios.get('/sendWorkerApply', {
                        params: {
                            workerid:workerid,
                            companyid:that.clickID,
                        }
                    })
                        .then(function (response) {
                            location.reload();
                        })
                        .catch(function (error) {
                            console.log(error);
                        });

                })
                .catch(function (error) {
                    console.log(error);
                });
        }

    },
    watch:{
        companyList:function(){
            this.$nextTick(function(){
                /*现在数据已经渲染完毕*/
                $('#dataTables-example').dataTable();
            })

        }

    }
})