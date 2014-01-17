/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午1:37
 * To change this template use File | Settings | File Templates.
 */
Ext.define('ZSMZJ.store.manager.Users',{
    extend:'Ext.data.Store',
    model:'ZSMZJ.model.manager.User',

    autoLoad:false,
    proxy:{
        type:'ajax',
        //url:'rain.do?pageModel=zjjb.test1.JustDoIt&eventName=doInit',
        url:'rain.do',
        extraParams:{
             pageModel:'zjjb.test1.JustDoIt',
            eventName:'doInit'
        },
        method:'POST',
        reader:{
            type:'json',
            root:'users',
            successProperty: 'success',
            totalProperty: 'totalCount'
        }
    }
})