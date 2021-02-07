
new Vue({
    //el:".get-code",
    //el:"#dowebok2",
    el:"",
    data:{
        show:true,
        code_time:5
    },
    methods:{
        time1:function (){
            this.code_time=this.code_time-1;
            console.log(this.code_time);
            if(this.code_time==0){
                clearInterval(this.time_count);
                this.time_count = null;
                this.code_time=5;
                this.show=!this.show;
            }
        },
        check_code:function (){
            this.show=!this.show;

            this.time_count = setInterval(this.time1,1000);
        }
    }
})

