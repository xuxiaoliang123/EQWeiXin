/**
 * 
 */
Ext.define('ZSMZJ.view.manager.sysFunctionForm',{
    alias:'widget.managersysfunctionform',
    extend:'Ext.form.Panel',
    width: 500,
    layout:{
    	type:'table',
    	columns: 1
    },
    border:false,

    cls:'panelsetcenter',
    initComponent:function(){
        Ext.tip.QuickTipManager.init();
        Ext.apply(this,{
            items: [
               
                {
                    xtype: 'textfield', //2
                    name: 'parent',
                    colspan: 2,
                    fieldLabel: '父结点',
                    value: ''
                },{
                    xtype: 'hiddenfield', //2
                    name: 'functionid',
                    itemId:'itemfunctionid',
                    colspan: 2,
                    fieldLabel: '功能id',
                    value: ''
                },{
                    xtype: 'textfield', //2
                    name: 'title',
                    colspan: 2,
                    fieldLabel: '功能名称',
                    value: ''
                },{
                    xtype:'textfield',
                    name:'location',
                    fieldLabel:'URL或者widget名',
                    colspan: 2,
                    width:500,
                    allowBlank:false
                },{
                    xtype:'textfield',
                    name:'orderno',
                    fieldLabel:'序号',
                    value:''
                },{
                    xtype:'jetselect',
                    searchtype:"aaa900",
                    name      : 'nodetype',
                    fieldLabel: '结点类型'
                },{
                    xtype:'jetselect',
                    searchtype:"aaa901",
                    name:'type',
                    fieldLabel:'功能类别'
                },
                {
                	xtype:'textfield',
                    name:'description',
                	fieldLabel:'中文描述'
                }
            ],

            tbar: [{
                text: '新建子节点',
                handler: function(c) {
                    var panel=c.up('panel').up('panel');
                    panel.fireEvent('newnodeclick',panel);

                }
            },{
                text: '保存',
                handler: function() {
                    var panel=this.up('panel').up('panel');
                    panel.fireEvent('savenodeclick',panel,"create");
                }
            },{
                text: '删除',
                handler: function() {
                    var panel=this.up('panel').up('panel');
                    panel.fireEvent('deletenodeclick',panel);
                }
            },{
                text: '刷新',
                handler: function() {
                    var panel=this.up('panel').up('panel');
                    panel.fireEvent('freshnodeclick',panel);
                }
            }]

        })

        this.callParent(arguments);
    }
})