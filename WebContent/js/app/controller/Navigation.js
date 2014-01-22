/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-21
 * Time: 下午7:46
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.controller.Navigation', {
    extend: 'Ext.app.Controller',

    stores:[
        'navigation.BasicTrees',
        'navigation.FunctionTrees'
    ],
    models:[
        'navigation.BasicTree'
    ],
    views:[
       'navigation.BasicTrees'
    ],
    init: function() {

        this.control({
            'navigationbasetree':{
                itemclick:function(c,r){var obj=r.raw;this.showtab(obj.text, obj.value, obj.type)}
            }
        });

    },

    closetab:function(value){
        var tabs = Ext.getCmp('mainContent-panel');
        var tab=tabs.getComponent(value);
        if (tab) {
            tab.close();
        }

    },
    showtab:function(label,value,type,objdata){
        if(ViewWaitMask){
            try{
                Ext.getCmp('mainContent-panel').getEl().unmask();
            }catch (e){

            }
        }
        ViewWaitMask=new Ext.LoadMask(Ext.getCmp('mainContent-panel').getEl(), {msg:"页面加载中..."});
        //ViewWaitMask.show();

        tabs = Ext.getCmp('mainContent-panel');

        tabid='tab'+label;
        var tab=tabs.getComponent(tabid);
        if (tab) {
            if(tab.isHidden()){
                tab.tab.show();
                tabs.setActiveTab(tab);
            }
        } else {
            if (type == '1') {
                function fn(){
                        /*var panel=Ext.create('Ext.panel.Panel',{
                            layout:{
                                type:'vbox',align: 'center'      //居中显示表单
                            },
                            closable: true,
                            bodyStyle:{backgroundColor:'#f1f1f1'},
                            id: tabid,
                            //objdata:objdata,
                            autoScroll: true,
                            iconCls: 'tabs',
                            title: label ,
                            items:[{
                                xtype: value
                            }]
                        })
                        tabs.add(panel).show();*/
                    tabs.add({
                        closable: true,
                        id: tabid,
                        xtype: value,
                        autoScroll: true,
                        iconCls: 'tabs',
                        title: label
                    }).show();

                }
                var task = new Ext.util.DelayedTask(fn);
                task.delay(50);


            } else if (type == "0") {
                tabs.add({
                    closable: true,
                    id: 'tab' + label,
                    html: '<iframe src="' + value + '" width="100%" height="100%" frameborder="0"></iframe>',
                    //loader: { url: "http://www.baidu.com", contentType: 'html', loadMask: 'loading...', autoLoad: true, scripts: true },
                    autoScroll: false,
                    iconCls: 'tabs',
                    title: label
                }).show();

            }

        }

    }
});