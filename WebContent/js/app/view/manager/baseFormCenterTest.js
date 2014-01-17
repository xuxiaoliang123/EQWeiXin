/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-31
 * Time: 下午7:26
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.baseFormCenterTest',{
    extend:'Ext.panel.Panel',
    alias:'widget.baseformcentertest',
    layout:{
        type:'anchor'
    },
    initComponent:function(){
        Ext.apply(this,{
            title:'test me',
            items:[
                {
                    xtype:'managersysuserquerycondition',
                    height: 200,
                    width: '50%'
                },{
                    xtype:'sysuserquerygrid'
                }
            ]
        })
        console.log(this)
        this.callParent(arguments);
    }



})