/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-28
 * Time: 下午4:25
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.store.manager.Divisions',{
    extend:'Ext.data.Store',
    groupField: 'aaa148',
    model:'ZSMZJ.model.manager.Division',
    proxy:{
         type:'ajax',
        url:'rain.do',
        extraParams:{
            pageModel:'sysmanager.Division',
            eventName:'queryDivision'
        },
        reader:{
            type:'json',
            root:'results',
            totalProperty:'totalCount'
        }
    }
})