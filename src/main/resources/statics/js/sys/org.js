var vm =new Vue({
    el: '#org',
    data:{
        search:{
            orgCodes:null,
            orgNames:null
        },
        orgList:[],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        showType:'list',
        showTitle:null,
        visible:false,
        orgForm:{
        }
    },
    methods:{
        reload: function () {
            vm.showType="list";
            vm.showTitle=null;
            vm.visible = false;
            this.getOrgList();
        },
        onSearch: function(){
        },
        getOrgList: function () {
            this.dataListLoading = true;
            var datas = "page="+this.pageIndex+"&limit="+this.pageSize;
            $.ajax({
                type: "GET",
                url:contextPath+"/org/getOrgList?_"+$.now(),
                data:datas ,
                dataType: "json",
                success: function(r){
                    if(r.retCode=="0000"){
                          vm.orgList = r.page.list;
                          vm.totalPage = r.page.total;
                    }else{
                        alert(r.retMsg);
                    }
                }
            });
            this.dataListLoading = false;
        },
        // 每页数
        sizeChangeHandle (val) {
            this.pageSize = val;
            this.pageIndex = 1;
            this.getOrgList();
        },
        // 当前页
        currentChangeHandle (val) {
            this.pageIndex = val;
            this.getOrgList();
        },
        // 多选
        selectionChangeHandle (val) {
            this.dataListSelections = val;
        },
        onCommon: function(url,datas){
            $.ajax({
                type: "POST",
                url:url,
                contentType: "application/json",
                data:datas ,
                success: function(r){
                    if(r.retCode== 0){
                        alert('操作成功');
                        vm.reload();
                    }else{
                        alert(r.retMsg);
                    }
                }
            });
        },
        onDelete: function(){
            var orgIds =this.dataListSelections;
            var jsonDatas=JSON.stringify(orgIds);
            var url = contextPath+"/org/deleteOrg";
            this.onCommon(url,jsonDatas);
        },
        onShowAdd: function(){
            vm.showType = "add";
            vm.showTitle = "新增机构";
            vm.visible=true;
            vm.orgForm={};
        },
        onShowUpdate:function(){
            vm.showType = "update";
            vm.showTitle = "编辑机构";
            vm.visible=true;
            vm.getOrg();
        },
        getOrg: function () {
            this.dataListLoading = true;
            var orgIds =this.dataListSelections;
            var datas = "orgId="+orgIds[0].id;
            $.ajax({
                type: "GET",
                url:contextPath+"/org/getOrg?_"+$.now(),
                data:datas ,
                dataType: "json",
                success: function(r){
                    if(r.retCode== 0){
                          vm.orgForm = r.org;
                    }else{
                        alert(r.retMsg);
                    }
                }
            });
            this.dataListLoading = false;
        },
        saveOrUpdate: function () {
            var url = vm.orgForm.id == null ? "/org/saveOrg" : "/org/updateOrg";
            var jsonDatas=JSON.stringify(vm.orgForm);
            url=contextPath + url;
            this.onCommon(url,jsonDatas);
        }
    },
    created: function(){
        this.getOrgList();
    }
});