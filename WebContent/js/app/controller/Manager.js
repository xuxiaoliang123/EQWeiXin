/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午1:10
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.controller.Manager',{
    extend:'Ext.app.Controller',
    stores:[
        'manager.Users',
        'manager.Functions',
        'manager.DivisionTrees',
        'manager.JetSelects',
        'manager.Divisions'
    ],
    models:[
        'manager.User',
        'manager.Function',
        'manager.JetSelect',
        'manager.Division'
    ],
    views:[
        'manager.baseForm',
        'manager.baseFormCenterTest',
        'manager.sysUserQueryCondition',
        'manager.sysUserQueryGrid',
        'manager.SquareshapedDiv',
        'manager.sysFunctionQueryGrid',
        'manager.sysDivisionBufQueryGrid',
        'manager.sysDivisionQueryTree',
        'manager.sysFunctionManagerPanel',
        'manager.sysFunctionTree',
        'manager.sysFunctionForm',
        'manager.JetSelect',
        'manager.Base64Md5Form',
        'manager.sysDivisionQueryGrid'
    ],
    init:function(){
        console.log("thise")
        this.control({
            'sysuserquerygrid,sysdivisionquerygrid,sysfunctionquerygrid,sysdivisionbufquerygrid':{
                render:function(c){

                    c.getStore().load();
                }
            },

            'sysfunctionquerygrid button[action=add]':{
                  click:function(c){
                      var grid= c.up('grid');
                      var rowEditor=grid.getPlugin('rowediting');
                      rowEditor.cancelEdit();
                      var r=Ext.ModelManager.create({
                          functionid:'sdfdfsadfdfefewewfwfewfewfewfw'
                      },'ZSMZJ.model.manager.Function')
                      var store=grid.getStore();
                      store.insert(store.getCount(),r);
                      rowEditor.startEdit(store.getCount(),0);
                  }
            },
            'sysfunctionquerygrid button[action=delete]':{
                click:function(c){
                      var grid= c.up('grid');
                    var store=grid.getStore();
                    var sm=grid.getSelectionModel();
                    var rowEditor=grid.getPlugin('rowediting');
                    rowEditor.cancelEdit();
                    store.remove(sm.getSelection());
                    if(store.getCount>0){
                        sm.select(0);
                    }
                }
            },
            'functionmanagerpanel':{
                'nodeclick':this.sysfnformloaddata,
                'newnodeclick':this.newfnnode,
                'savenodeclick':this.savefnnode,
                'deletenodeclick':this.deletefnnode,
                'freshnodeclick':this.freshfnnode
            }

        });
    },
    sysfnformloaddata:function(c,r){
        var form = c.up('panel').down('#managersysfunctionform').getForm();
        Ext.Ajax.request({
            url: 'rain.do',
            params: {
                node: r.data.id,
                pageModel:'sysmanager.Function',
                eventName:'queryFunctionById'
            },
            success: function(response){
                var text = Ext.JSON.decode(response.responseText);
                form.setValues(text)
            }
        });
    },
    newfnnode:function(c){
        console.log(c)
        var obj=c.down('#managersysfunctiontree').getSelectionModel().selected.first();
        if(obj){
            var parent='';
            var f=obj.raw;
            if(f.leaf){
                return;
            }else{
                parent= f.id;
            }
            var form = c.down('#managersysfunctionform').getForm();
            form.reset();
            form.setValues({
                parent:parent,
                functionid:'-1'
            })
        }
    },
    savefnnode:function(c){  //expandAll
        var form = c.down('#managersysfunctionform').getForm();
        var field = c.down('#itemfunctionid');
        var tree=c.down('#managersysfunctiontree');
        var a=field.getValue()=='-1'?"create":"update";
        form.submit({
            clientValidation: false,
            url: 'rain.do?pageModel=sysmanager.Function',
            params: {
                eventName:a
            },
            success: function(form, action) {
                Ext.Msg.alert('Success', '保存成功');
                tree.expandAll();
            },
            failure: function(form, action) {
                Ext.Msg.alert('failure', '失败');
            }
        });
    },
    deletefnnode:function(c){
        var field = c.down('#itemfunctionid');
        Ext.Ajax.request({
            url: 'rain.do',
            params: {
                functionid: field.getValue(),
                pageModel:'sysmanager.Function',
                eventName:'delete'
            },
            success: function(response){
                Ext.Msg.alert('Success', '保存成功');
            }
        });
    },
    freshfnnode:function(c){
        var tree=c.down('#managersysfunctiontree');
        var obj=tree.getSelectionModel().selected.first();
        if(!obj){
            return;
        }


    }
})