/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午5:10
 * To change this template use File | Settings | File Templates.
 */


Ext.define('ZSMZJ.view.groupsend.contactsWin',{

    alias:'widget.groupsendcontactswin',
    extend:'Ext.window.Window',
    title: 'Hello',
    height: 400,
    width: 600,
    layout: 'fit',
    items: {  // Let's put an empty grid in just to illustrate fit layout
        xtype: 'grid',
        border: false,
        columns: [{header: 'World'}],                 // One header just for show. There's no data,
        store: Ext.create('Ext.data.ArrayStore', {}) // A dummy empty data store
    },
    initComponent:function(){
        this.callParent(arguments);
    }
})