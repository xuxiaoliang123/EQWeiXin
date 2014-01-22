/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-21
 * Time: 下午3:08
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.earthquakeknowledge.KnowledgeQueryParamForm',{
    extend:'Ext.form.Panel',
    alias:'widget.earthquakeknowledgequeryparamform',
    border:false,
    layout: {
        type: 'table'/*,
        // The total column count must be specified here
        columns: 3*/
    },
    bodyStyle: {
        //background: '#ffc',
        padding: '10px'
    },

    fieldDefaults: {
        msgTarget: 'side',
        labelWidth: 75
    },
    /*plugins: {
        ptype: 'datatip'
    },*/
    defaultType: 'textfield',

    initComponent:function(){
        var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
        Ext.apply(this,{
            items:[
                {
                    fieldLabel: '种类',
                    name: 'last',
                    allowBlank: false,
                    tooltip: 'Enter your last name'
                },{
                    fieldLabel: '简要',
                    name: 'company'
                }, {
                    fieldLabel: '创建人',
                    name: 'email'
                }, {
                    fieldLabel: '创建时间',
                    name: 'dob',
                    xtype: 'datefield',
                    tooltip: 'Enter your date of birth'
                }
            ],
            tbar: [

            '->',
            {
                text: '查询',
                handler: function() {
                    this.up('form').fireEvent('knowledgequery');
                }
            },{
                text: '删除',
                handler: function() {
                    this.up('form').getForm().reset();
                }
            },{
                text: '新增知识',
                handler: function() {
                    this.up('form').up('panel').fireEvent('addknowledge');
                }
            }]
        })


        this.callParent(arguments);
    }
})