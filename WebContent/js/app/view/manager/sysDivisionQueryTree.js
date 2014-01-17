/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-29
 * Time: 下午8:05
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.sysDivisionQueryTree',{
    extend:'Ext.tree.Panel',
    alias:'widget.sysdivisionquerytree',
    requires: [
        'Ext.tree.*',
        'Ext.data.*'
    ],
    title: '操作菜单',
    width:250,
    height:500,
    store:'manager.DivisionTrees',
    rootVisible:false,
    initComponent : function(){
        this.callParent(arguments);
    }
})