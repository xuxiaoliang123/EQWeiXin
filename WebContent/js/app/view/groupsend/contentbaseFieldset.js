/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */


Ext.define('ZSMZJ.view.groupsend.contentbaseFieldset', {
    extend : 'Ext.form.FieldSet',
    alias : 'widget.contentbasicfieldset',
    style: {
        border:'0px'
    },
    //requires: ['Ext.ux.form.HtmlEditor.Plugins'],

    initComponent: function() {
        var required = '<span style="color:red;font-weight:bold" data-qtip="必填字段">*</span>';
        Ext.apply(this,
            {
                title: '<span style="line-height: 30px;">【群发】基本信息</span>',
                defaultType: 'textfield',
                cls:'fieldset-border',
                //style:"border:0px solid gray;",
                layout: {
                    type: 'table',
                    columns: 3,
                    tdAttrs:{style: "border:0px solid #2E2E2E;width:330px"},
                    tableAttrs: {
                        border: 1,
                        cellpadding: 5,
                        cellspacing: 0,
                        width: '100%',
                        //align: 'center',
                        style: "border:0px solid #2E2E2E;border-collapse:collapse;margin:0 auto;text-align:left;"
                        /*style: {
                         width: '100%'
                         }*/
                    }
                },

                items: [
                    {
                        name: 'sendee',
                        fieldLabel: '接收人',
                        colspan:3,
                        width:1000,
                        height:40,
                        xtype : 'textarea',
                        grow : false,
                        itemId:'itemsendee',
                        allowBlank: true
                    },
                    {

                        xtype: 'textareafield', //2
                        name: 'title',
                        fieldLabel: '主　题',
                        width:1000,
                        height:40,
                        colspan: 3,
                        labelAlign:'right',
                        value: ''
                    },{
                        xtype:'jetselect',
                        name: 'aaa104',
                        searchtype:"aaa104",
                        fieldLabel: '主题类别',
                        afterLabelTextTpl: required,
                        allowBlank: false
                    }
                    ,{
                        xtype: 'filefield',
                        name: 'photo',
                        fieldLabel: '上传图片',
                        msgTarget: 'side',
                        allowBlank: false,
                        buttonText: 'Select Photo...'
                    },{
                        xtype: 'datefield',
                        fieldLabel: '发送时间',
                        format: 'Y-m-d',
                        name: 'to_date',
                        value: new Date()  // defaults to today
                    },{
                        xtype:'htmleditor',
                        name:'myhtmlcontent',
                        width:1000,
                        colspan: 3,
                        fieldLabel: '编辑',
                        labelAlign:'right',
                        //plugins:Ext.ux.form.HtmlEditor.plugins(),
                        height:300
                    }

                ]

            }
        );
        this.callParent(arguments);

    }

});