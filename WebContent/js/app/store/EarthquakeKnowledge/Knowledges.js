/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-21
 * Time: обнГ4:26
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.store.earthquakeknowledge.Knowledges',{
    extend:'Ext.data.Store',
    model:'ZSMZJ.model.earthquakeknowledge.Knowledge',
    autoLoad:true,
    proxy:{
        type:'ajax',
        url:'rain.do',
        extraParams:{
            pageModel:'earthquake.knowledge.Knowledge',
            eventName:'queryKnowledge'
        },

        reader:{
            type:'json',
            root:'results',
            totalProperty:'totalCount'
        }
    }
})