/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午3:58
 * To change this template use File | Settings | File Templates.
 */


Ext.define('ZSMZJ.store.manager.JetSelects', {
    extend: 'Ext.data.Store',
    model: 'ZSMZJ.model.manager.JetSelect',
    alias : 'widget.managerjetselects',



    autoLoad:false,
    proxy:{
        type: 'ajax',
        getMethod:function(request){ return 'POST'; },
        url: 'rain.do?pageModel=sysmanager.JetSelect&eventName=select'
    }

});