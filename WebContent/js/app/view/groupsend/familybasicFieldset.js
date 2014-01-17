/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */


Ext.define('ZSMZJ.view.groupsend.familybasicFieldset', {
    extend : 'Ext.form.FieldSet',
    alias : 'widget.familybasicfieldset',
    requires: [


    ],

    initComponent: function() {
        var required = '<span style="color:red;font-weight:bold" data-qtip="必填字段">*</span>';
        Ext.apply(this,
            {
                title: '<a>【低保业务办理】家庭基本信息</a>',
                defaultType: 'textfield',
                cls:'fieldset-border',
                //style:"border:0px solid gray;",
                layout: {
                    type: 'table',
                    columns: 3,
                    tdAttrs:{style: "border:1px solid #2E2E2E;width:330px"},
                    tableAttrs: {
                        border: 1,
                        cellpadding: 5,
                        cellspacing: 0,
                        width: '100%',
                        //align: 'center',
                        style: "border:1px solid #2E2E2E;border-collapse:collapse;margin:0 auto;text-align:left;"
                        /*style: {
                         width: '100%'
                         }*/
                    }
                },

                items: [{
                    name: 'division',
                    fieldLabel: '行政区划',
                    itemId:'divisiontype',
                    xtype:'dbgldivsioncombtreepath',
                    allowBlank: false,
                    blankText: "不能为空",
                    displayField: 'text',
                    valueField:'id',
                    afterLabelTextTpl: required,
                    emptyText: '请输入行政区划',
                    blankText : '请输入行政区划',
                    colspan:2,//合并列
                    allowBlank: false
                },
                    {
                        xtype:'jetselect',
                        name: 'applytype',
                        searchtype:"dbglapplytype",
                        fieldLabel: '申请类别',
                        emptyText: '请输入申请类别',
                        blankText: '请输入申请类别',
                        afterLabelTextTpl: required,
                        allowBlank: false

                        /*name: 'applytype',
                         afterLabelTextTpl: required,
                         fieldLabel: '申请类别',
                         emptyText: '请输入申请类别',
                         blankText: '请输入申请类别',*/

                    },{
                        xtype:'jetselect',
                        name: 'poortype',
                        searchtype:"dbglpoortype",
                        fieldLabel: '分类管理',
                        afterLabelTextTpl: required,
                        emptyText: '请输入家庭类别',
                        blankText: '请输入家庭类别',
                        allowBlank: false
                    }
                    ,{
                        name: 'owername',
                        itemId:'owername',
                        fieldLabel: '户主姓名',
                        listeners: {

                            "blur":function(field,e){
                                var name = field.getRawValue().replace(/\s+/g, "");
                                this.fireEvent('owerchange', field);

                            }
                        },

                        afterLabelTextTpl: required,
                        blankText: '请输入户主姓名',
                        emptyText: '请输入户主姓名',
                        allowBlank: false
                    },{
                        name: 'owerid',
                        itemId:'owerid',
                        fieldLabel: '户主身份证',
                        vtype:'personid',
                        listeners: {

                            "blur":function(field,e){
                                var name = field.getRawValue().replace(/\s+/g, "");
                                this.fireEvent('owerchange', field);

                            }
                        },
                        afterLabelTextTpl: required,
                        blankText: '请输入身份证号',
                        emptyText: '请输入身份证号',
                        allowBlank: false
                    }

                    ,{
                        name: 'accountaddress',
                        fieldLabel: '户主户口所在地',
                        //colspan:2,
                        //afterLabelTextTpl: required,
                        //emptyText: '低保户类型',
                        allowBlank: true
                    },{
                        name: 'accountzipcode',
                        fieldLabel: '邮政编码',
                        //afterLabelTextTpl: required,
                        //emptyText: '低保户类型',
                        allowBlank: true
                    },{
                        name: 'realaddress',
                        //colspan:2,
                        fieldLabel: '实际居住地',
                        allowBlank: true
                    },{
                        name: 'realzipcode',
                        fieldLabel: '邮政编码',
                        //afterLabelTextTpl: required,
                        //emptyText: '低保户类型',
                        allowBlank: true
                    },{
                        itemId: 'FamilyPersons',
                        name: 'familynum',
                        fieldLabel: '家庭总人口',
                        afterLabelTextTpl: required,
                        blankText:'家庭总人口',
                        value:0,
                        /*disabled:true,*/
                        readOnly:true,

                        //emptyText: '低保户类型',
                        disabledCls:'yw-disabled-field-cls',

                        allowBlank: false
                    }
                    ,{
                        name: 'telnum',
                        fieldLabel: '联系电话',
                        //afterLabelTextTpl: required,
                        //emptyText: '低保户类型',
                        allowBlank: true
                    },{
                        xtype:'jetselect',
                        searchtype:"dbglbank",
                        name: 'bank',
                        fieldLabel: '开户银行',
                        afterLabelTextTpl: required,
                        emptyText: '请选择开户银行',
                        blankText:'开户银行',
                        allowBlank: false
                    }
                    ,{
                        name: 'bankower',
                        fieldLabel: '开户人',
                        //afterLabelTextTpl: required,
                        //emptyText: '低保户类型',
                        allowBlank: true
                    },{
                        name: 'bankid',
                        fieldLabel: '银行账号',
                        colspan:2,
                        //afterLabelTextTpl: required,
                        //emptyText: '低保户类型',
                        allowBlank: true
                    },{
                        name: 'otherfamilyinfo',
                        fieldLabel: '家庭备注',
                        colspan:3,
                        minWidth:300,
                        width:800,
                        //draggable :true,
                        //anchor : '100%',
                        //width:800,
                        xtype : 'textarea',
                        grow : false,

                        //afterLabelTextTpl: required,
                        //emptyText: '低保户类型',
                        allowBlank: true
                    }
                ]

            }
        );
        this.callParent(arguments);

    }

});
