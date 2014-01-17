/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-5
 * Time: 下午2:00
 * To change this template use File | Settings | File Templates.
 */


Ext.define('ZSMZJ.view.manager.sysUserQueryCondition',{
    extend:'Ext.form.Panel',
    alias:'widget.managersysuserquerycondition',
    layout:{
        type:'table',
        columns:2
    },
    bodyStyle: {
        background: '#ffc',
        padding: '10px'
    },
    initComponent:function(){
        console.log(this)
        Ext.apply(this,{
            items:[
                {
                    xtype:'textfield',
                    fieldLabel:'textfield'
                },{
                    xtype:'textfield',
                    fieldLabel:'textfield'
                },{
                    xtype:'textfield',
                    fieldLabel:'textfield'
                },{
                    xtype:'textfield',
                    fieldLabel:'textfield'
                },{
                    xtype:'textfield',
                    fieldLabel:'textfield'
                }

            ]
        })

        this.callParent(arguments);
    }
})