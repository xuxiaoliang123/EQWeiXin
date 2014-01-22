/**
 * Created with IntelliJ IDEA.
 * User: weipan
 * Date: 14-1-21
 * Time: 下午2:12
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.earthquakeknowledge.Entry',{
    extend:'Ext.form.Panel',
    alias:'widget.earthquakeknowledgeentry',
    autoScroll: true,
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 100,
        msgTarget: 'side'
    },
    initComponent:function(){

        Ext.apply(this,{
           items:[
               {
                   xtype:'earthquakeknowledgefieldset'
               }
           ],
            tbar: [

                {
                    text: '存草稿',

                    handler: function () {

                    }
                },
                {
                    text: '确认保存',
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
                },
                '->',
                {
                    text: '取消'
                },
                {
                    text: '预览'
                }
            ]

        })



        this.callParent(arguments);
    }
})

