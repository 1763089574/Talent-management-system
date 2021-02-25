var companyList = new Vue({
    el:'#list',
    data:{
        companyList:[]
    },
    created:function (){
        this.getCompanyList();

    },
    methods: {
        getCompanyList() {
            var that = this;
            axios.get('/getAllHasIdentifyCompanies')
                .then(function (response) {
                    console.log(response);
                    that.companyList = response.data;
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