/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-29
 * Time: 下午7:51
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.store.manager.DivisionTrees',{
    extend:'Ext.data.TreeStore',
    autoLoad:false,
    proxy:{
        type:'ajax',
        url:'rain.do',
        extraParams:{
             pageModel:'sysmanager.Division',
            eventName:'queryDivisionTree'
        },
        reader : {
            type : 'json'
        },
        root: {
            text: '树根',
            id: '00',
            expanded: true
        },
        folderSort: true,
        sorters: [{
            property: 'id',
            direction: 'ASC'
        }]

    }
})