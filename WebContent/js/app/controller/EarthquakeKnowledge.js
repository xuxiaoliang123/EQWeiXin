/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-21
 * Time: 下午2:10
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
        'earthquakeknowledge.contentbaseFieldset',
        'earthquakeknowledge.KnowledgeQueryGrid'

    ],

    init:function(){

        var nav_ctrl=this.application.getController("Navigation");
        this.control({
            'earthquakeknowledgepanel':{
                'addknowledge':function(){
                    nav_ctrl.showtab('地震知识新增','earthquakeknowledgeentry','1')
                },
                'toeditknowledge':function(){
                    nav_ctrl.showtab('地震知识编辑','earthquakeknowledgeentry','1')
                }
            }
        });
    }
})