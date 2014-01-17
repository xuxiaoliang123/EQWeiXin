/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-31
 * Time: 下午7:26
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.baseForm',{
    alias:'widget.managerbaseform',
    extend:'Ext.form.Panel',
    fieldDefaults: {
        labelAlign: 'left',
        labelWidth: 90,
        msgTarget: 'under',
        anchor: '100%'
    },
    width:1000,
    border:false,

    cls:'panelsetcenter',
    initComponent:function(){
        Ext.tip.QuickTipManager.init();
        Ext.apply(this,{
            items: [
                {
                    xtype: 'hiddenfield', //1
                    name: 'hiddenfield1222',
                    value: 'Hidden field value222',
                    allowBlank:false
                },
                {
                    xtype: 'displayfield', //2
                    name: 'displayfield1',
                    fieldLabel: 'Display field',
                    value: 'Display field <span style="color:red;">value</span>'
                },{
                    xtype:'textfield',
                    name:'textfield1',
                    fieldLabel:'text field',
                    value:'textfield value',
                    allowBlank:false
                },{
                    xtype:'textfield',
                    name:'textfield2',
                    inputType:'password',
                    fieldLabel:'password field',
                    value:'textfield2 value'
                },{
                    xtype     : 'textareafield',
                    name      : 'message',
                    fieldLabel: 'Message',
                    value:'今天是2013年的最后一天,让我们期待2014的到来吧22'
                },{
                    xtype: 'filefield',
                    name: 'photo',
                    fieldLabel: 'Photo',
                    msgTarget: 'side',
                    allowBlank: false,
                    buttonText: 'Select Photo...'
                },{
                    xtype: 'timefield',
                    name: 'in',
                    fieldLabel: 'Time In',
                    minValue: '6:00 AM',
                    maxValue: '8:00 PM',
                    increment: 30
                },{
                    xtype: 'datefield',
                    fieldLabel: 'To',
                    format: 'Y-m-d',
                    name: 'to_date',
                    value: new Date()  // defaults to today
                },{
                    xtype: 'combobox', //9
                    fieldLabel: 'Combobox',
                    displayField: 'name',
                    store: Ext.create('Ext.data.Store', {
                        fields: [
                            {type: 'string', name: 'name'}
                        ],
                        data: [
                            {"name":"Alabama"},
                            {"name":"Alaska"},
                            {"name":"Arizona"},
                            {"name":"Arkansas"},
                            {"name":"California"}
                        ]
                    }),
                    queryMode: 'local',
                    typeAhead: true
                },{
                    xtype:'numberfield',
                    name:'mynumber',
                    fieldLabel:'number filed',
                    value:99,
                    minValue:0,
                    maxValue:99
                },{
                    xtype: 'checkboxfield', //11
                    name: 'checkbox1',
                    fieldLabel: 'Checkbox',
                    boxLabel: 'box label'
                },{
                    xtype: 'radiofield', //12
                    name: 'radio1',
                    value: 'radiovalue1',
                    fieldLabel: 'Radio buttons',
                    boxLabel: 'radio 1'
                },{
                    xtype: 'radiofield', //12
                    name: 'radio1',
                    value: 'radiovalue2',
                    labelSeparator: '',
                    hideEmptyLabel: false,
                    fieldLabel: '',
                    boxLabel: 'radio 2'
                },{
                    xtype: 'multislider', //14
                    fieldLabel: 'Multi Slider',
                    values: [25, 50, 75],
                    increment: 5,
                    minValue: 0,
                    maxValue: 100
                },{
                    xtype: 'sliderfield', //15
                    fieldLabel: 'Single Slider',
                    value: 50,
                    increment: 10,
                    minValue: 0,
                    maxValue: 100
                },{
                    xtype:'htmleditor',
                    name:'myhtmlcontent',
                    height:200
                }
            ],

            buttons: [{
                text: 'Load',
                handler: function() {
                    var form = this.up('form').getForm();
                    form.load({
                        url: 'data/form.json',
                        failure: function(form, action) {
                            Ext.Msg.alert("Load failed", action.result.errorMessage);
                        }
                    });
                }
            },{
                text: 'Submit',
                handler: function() {
                    var form = this.up('form').getForm();
                    form.submit({
                        url: 'form-submit.php',
                        waitMsg: 'Sending the info...',
                        success: function(fp, o) {
                            Ext.Msg.alert('Success', 'Form submitted.');
                        }
                    });
                }
            }]

        })

        this.callParent(arguments);
    }
})