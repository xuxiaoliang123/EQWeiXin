/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午1:20
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ZSMZJ.view.groupsend.ContentForm',{
    alias:'widget.groupsendcontentform',
    extend:'Ext.form.Panel',
    border:false,
    autoScroll: true,
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 100,
        msgTarget: 'side'
    },


    initComponent:function(){
        Ext.tip.QuickTipManager.init();
        Ext.apply(this,{
            items:[
                {xtype:'contentbasicfieldset'}
            ],

            tbar: [

                {
                    text: '存草稿',

                    handler: function () {

                    }
                },
                {
                    text: '发送',
                    cls:'tbarbtnover',
                    handler: function () {
                        var form = this.up('form').getForm();
                        form.submit({
                            url: 'form-submit.php',
                            waitMsg: 'Sending the info...',
                            success: function (fp, o) {
                                Ext.Msg.alert('Success', 'Form submitted.');
                            }
                        });
                    }
                },{
                    text: '选择接收人',
                    handler: function () {
                        Ext.widget('groupsendcontactswin').show();
                    }
                },
                '-',
                {
                    text: '查看群发日志/记录',
                    handler: function () {
                        alert(this.text)
                    }
                },
                '->',
                {
                    text: '取消'
                },
                {
                    text: '预览'
                },
                {
                    text: 'Load3'
                }
            ]

        })

        this.callParent(arguments);
    }
})