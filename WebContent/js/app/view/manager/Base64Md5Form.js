/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-16
 * Time: 下午8:52
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ZSMZJ.view.manager.Base64Md5Form',{
    alias:'widget.base64tringifymd5string',
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
                //select '['||id||','||'"'||password||'"],' from users
                {
                    xtype: 'displayfield', //2
                    name: 'displayfield1',
                    fieldLabel: 'Display field',
                    value: 'Display field <span style="color:red;">MD5->BASE64->CODE<br/>' +
                        '</span>'
                },{
                    xtype:'textareafield',
                    name:'textfield2',

                    fieldLabel:'password field',
                    height:250,
                    itemId:'textarea1'
                },{
                    xtype     : 'textareafield',
                    height:250,
                    name      : 'message',
                    fieldLabel: 'Message',
                    itemId:'textarea2'
                }
            ],

            buttons: [{
                text: 'Submit',
                handler: function() {

                    var f1 = this.up('form').down('#textarea1');
                    var f2 = this.up('form').down('#textarea2');
                    var arr=eval('['+f1.getValue().toString()+']');
                    var len=arr.length;
                    var result="";
                    function tt(){
                        for(var i=0;i<len;i++){
                            var s="update users set password='"+CryptoJS.enc.Base64.stringify(CryptoJS.MD5(arr[i][1]+''))+"' where id="+arr[i][0]+";\n";
                            result+=s;
                        }
                        return result;
                    }
                    f2.setValue(tt());
                }
            }]

        })

        this.callParent(arguments);
    }
})