/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-28
 * Time: 下午8:49
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.store.manager.Functions',{
    extend:'Ext.data.Store' ,
    model:'ZSMZJ.model.manager.Function' ,
    proxy:{
          type:'ajax',
        url:'rain.do',
        extraParams:{
            pageModel:'sysmanager.Function',
            eventName:'queryFunction'
        },
        reader:{
            type:'json',
            root:'results',
            totalProperty:'totalCount'
        }
    }
})