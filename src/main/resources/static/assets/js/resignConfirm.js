var resignConfirm = new Vue({
    el:'#list',
    data:{
        resignList:[],
        clickCompanyName:"",
        clickID:"",
        resignContent:"",
        workerId:""
    },
    created:function (){
        this.getResignList();

    },
    methods: {

        getResignList() {
            var that = this;

                    axios.get('/GlobalVariable/GetWorkerId')
                        .then(function (response) {
                            var workerid = response.data;
                            that.workerId=workerid;
                            axios.get('/getNowCompanyInformationPlus', {
                                params: {
                                    workerid: workerid
                                }
                            })
                                .then(function (response) {
                                    console.log(response);
                                    that.resignList = response.data;
                                })
                                .catch(function (error) {
                                    console.log(error);
                                });

                        })
                        .catch(function (error) {
                            console.log(error);
                        });

        },
        // getCompanyID(id,name){
        //     this.clickID = id;
        //     this.clickCompanyName = name;
        // },
        sendApply(){
            var that =this;

                    axios.get('/addResignApply', {
                        params: {
                            workerId:that.workerId,
                            companyId:that.resignList.companyId,
                            content:that.resignContent
                        }
                    })
                        .then(function (response) {
                               alert("成功发送！");
                               location.reload();

                        })
                        .catch(function (error) {
                            alert("申请失败！");
                        });


        }

    },
    watch:{
        resignList:function(){
            this.$nextTick(function(){
                /*现在数据已经渲染完毕*/
                $('#dataTables-example').dataTable();
            })

        }

    }
})