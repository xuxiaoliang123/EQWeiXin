/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午1:12
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.groupsend.ContentPanel',{
    alias:'widget.groupsendcontentpanel',
    extend:'Ext.panel.Panel',
    border:false,
    layout:'fit',

    initComponent:function(){

        Ext.apply(this,{
            items:[
                {
                    html:'<div>good</div>'
                }
            ]
        })

        this.callParent(arguments);
    }
})