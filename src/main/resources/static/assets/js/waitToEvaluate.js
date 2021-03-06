var waitToEvaluate = new Vue({
    el:'#list',
    data:{
        evaluateList:[],
        clickingEvaluateId:"",
        evaluateContent:"",
        companyName:"",
        endDate:"",
        startDate:"",
        aveGrade:"",
        mistakes:[],
        achievements:[],
        dossierEvalaute:"",
        myEvalaute:""
    },
    created:function (){
        this.getEvaluateList();

    },
    filters: {
        ellipsis(value) {
            if (!value) return ''
            if (value.length > 10) {
                return value.slice(0, 10)
            }
            return value
        }
    },
    methods: {

        getEvaluateList() {
            var that = this;

            axios.get('/GlobalVariable/GetWorkerId')
                .then(function (response) {
                    var workerid = response.data;

                    axios.get('/getAllWaitToEvaluateList', {
                        params: {
                            workerId:workerid
                        }
                    })
                        .then(function (response) {
                            console.log(response.data);
                            that.evaluateList = response.data;
                        })
                        .catch(function (error) {
                            console.log(error);
                        });
                })
                .catch(function (error) {
                    console.log(error);
                });

        },
        getEmployID(evaluateId){
            this.clickingEvaluateId = evaluateId;

        },
        addResignEvaluate(){
            var that =this;
            if(that.evaluateContent==""){
                alert("评价不能为空！！");
            }else if(that.evaluateContent.trim()==""){
                alert("评价不能全是空格！");
            }else{
                axios.get('/addEvaluateContent', {
                    params: {
                        content:that.evaluateContent,
                        evaluateId:that.clickingEvaluateId
                    }
                })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            }
        },
        checkInformation(employId){
            var that = this;
            axios.get('/getOnjobRecordByEmployId', {
                params: {
                    employId: employId
                }
            })
                .then(function (response) {
                    console.log(response);
                    that.companyName=response.data.employObjiect.companyName;
                    that.endDate =response.data.employObjiect.endDate;
                    that.startDate =response.data.employObjiect.startDate;
                    that.aveGrade = response.data.aveGrade;
                    that.mistakes = response.data.MistakesList;
                    that.achievements = response.data.AchievementList;
                    that.dossierEvalaute = response.data.dossierObject.evaluate;
                    that.myEvalaute = response.data.evaluateObject.evaluatecontent;

                })
                .catch(function (error) {
                    console.log(error);
                });
        }


    },
    watch:{
        evaluateList:function(){
            this.$nextTick(function(){
                /*现在数据已经渲染完毕*/
                $('#dataTables-example').dataTable();
            })

        }

    }
})