var ownCompany = new Vue({
    el:'#page-wrapper',
    data:{
        nowCompanyName:"",
        nowCompanyStartTime:"",
        nowCompanyAchievement:"",
        nowCompanyMistake:"",
        nowCompanyAverageGrade:""
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
    created:function (){
        this.getNowCompanyInformation();
    },
    methods:{
        getNowCompanyInformation(){
            var that = this;
            axios.get("/GlobalVariable/GetWorkerId") .then()
                .then(function (response) {

                    var workerid = response.data;
                    axios.get('/getNowCompanyInformation', {
                        params: {
                            workerid:workerid
                        }
                    })
                        .then(function (response) {
                            console.log(response);
                            that.nowCompanyName = response.data.companyName;
                            that.nowCompanyStartTime=response.data.startDate;
                            that.nowCompanyAchievement=response.data.nowCompanyAchievements;
                            that.nowCompanyMistake=response.data.nowCompanyMistakes;
                            that.nowCompanyAverageGrade=response.data.averageGrade;
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