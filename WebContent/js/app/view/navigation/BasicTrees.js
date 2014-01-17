/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-21
 * Time: 下午7:43
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.navigation.BasicTrees', {
    extend: 'Ext.tree.Panel',
    alias:'widget.navigationbasetree',
    requires: [
        'Ext.tree.*',
        'Ext.data.*'
    ],

    initComponent: function() {
        Ext.apply(this,{
            loadMask:{msg:'加载中...'},
            rootVisible:false,
            store: 'navigation.BasicTrees',
            //store: 'navigation.FunctionTrees',
            listeners: {
                //itemclick: function(){ console.log('click el'); }
            }
        })

        this.callParent(arguments);
    }
});