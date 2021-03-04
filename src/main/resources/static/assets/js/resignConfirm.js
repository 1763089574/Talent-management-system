var resignConfirm = new Vue({
    el:'#list',
    data:{
        resignList:[],
        clickCompanyName:"",
        clickID:""
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

                            axios.get('/getResignList', {
                                params: {
                                    workerId: workerid
                                }
                            })
                                .then(function (response) {
                                    console.log(response.data);
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
        getCompanyID(id,name){
            this.clickID = id;
            this.clickCompanyName = name;
        },
        sendApply(){
            var that =this;
            axios.get("/GlobalVariable/GetWorkerId") .then()
                .then(function (response) {

                    var workerid = response.data;
                    axios.get('/confirmResignApply', {
                        params: {
                            resignId:that.clickID
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
        resignList:function(){
            this.$nextTick(function(){
                /*现在数据已经渲染完毕*/
                $('#dataTables-example').dataTable();
            })

        }

    }
})