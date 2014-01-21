/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午12:58
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.controller.GroupSend',{
    extend:'Ext.app.Controller',

    models:[],
    stores:[],
    views:[
        'groupsend.ContentPanel',
        'groupsend.familybasicFieldset',
        'groupsend.contentbaseFieldset',
        'groupsend.contactsWin',
        'groupsend.ContentForm'
    ],
    init:function(){

    }
})