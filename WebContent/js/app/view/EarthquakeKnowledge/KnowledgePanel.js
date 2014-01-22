/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-21
 * Time: обнГ3:10
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.earthquakeknowledge.KnowledgePanel',{
    extend:'Ext.form.Panel',
    alias:'widget.earthquakeknowledgepanel',
    initComponent:function(){

        Ext.apply(this,{
            items:[
                {
                    xtype:'earthquakeknowledgequeryparamform'
                },{
                    xtype:'earthquakeknowledgequerygrid'
                }
            ]
        })



        this.callParent(arguments);
    }
})