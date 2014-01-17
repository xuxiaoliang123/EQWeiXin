/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-22
 * Time: 下午6:53
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.model.navigation.BasicTree', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id'},
        {name: 'text', type: 'string'},
        {name: 'leaf'     },
        {name: 'iconCls', type: 'string', defaultValue: 'treenode-no-icon'},
        {name: 'expanded', type: 'boolean', defaultValue: true, persist: false},
        {name: 'value', type: 'string' },
        {name: 'type', type: 'string' }
    ]

})