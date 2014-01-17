/**
 * 
 */
Ext.define('ZSMZJ.view.manager.sysFunctionTree', {
    extend: 'Ext.tree.Panel',
    alias:'widget.managersysfunctiontree',
    requires: [
        'Ext.tree.*',
        'Ext.data.*'
    ],

    initComponent: function() {
        var me=this;
        Ext.apply(this,{
            loadMask:{msg:'加载中...'},
            rootVisible:false,
            //store: 'navigation.BasicTrees',
            //store: 'navigation.FunctionTrees',
            store:Ext.create('Ext.data.TreeStore',{
                autoLoad:false,
                proxy:{
                    type:'ajax',
                    url:'rain.do?myfn=good',
                    extraParams:{
                        pageModel:'sysmanager.Function',
                        eventName:'queryFunctionTree',
                        node:me.parentnode
                    },
                    reader : {
                        type : 'json'
                    }

                }

            }),
            listeners: {
                itemclick: function(c,r){
                    console.log(c);
                    console.log(r);
                    //r.removeAll();


                    this.up('panel').fireEvent('nodeclick',this,r);
                    /*this.load({
                        node:r,
                        callback:function(){
                            c.refresh();
                        }
                    })*/
                },
                afterrender:function(){
                    this.getStore().proxy.extraParams={
                        pageModel:'sysmanager.Function',
                        eventName:'queryFunctionTree'
                    };
                    console.log("$$$$$$$$$$$$$$$$$$$")
                }
            }
        })

        this.callParent(arguments);
    }
});