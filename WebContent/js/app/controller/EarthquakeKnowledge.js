/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-21
 * Time: ÏÂÎç2:10
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.controller.EarthquakeKnowledge',{
    extend:'Ext.app.Controller',

    stores:[
        'earthquakeknowledge.Knowledges'
    ],
    models:[
        'earthquakeknowledge.Knowledge'
    ],
    views:[
        'earthquakeknowledge.Entry',
        'earthquakeknowledge.KnowledgePanel',
        'earthquakeknowledge.KnowledgeQueryParamForm',
        'earthquakeknowledge.KnowledgeQueryGrid'

    ],

    init:function(){

        console.log(this)
        this.control({

        });
    }
})