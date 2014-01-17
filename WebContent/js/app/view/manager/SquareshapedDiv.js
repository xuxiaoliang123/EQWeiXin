/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-5
 * Time: 下午2:56
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.SquareshapedDiv',{
    extend:'Ext.Component',
    alias:'widget.squareshapeddiv',
    autoEl: {
        tag: 'div',
        html:'<div class="yw-block">' +
            '<div class="yw-stepzerobgcolor"></div><span>申请</span>'+
            '<div class="yw-steponebgcolor"></div><span>提交</span>'+
            '<div class="yw-steptwobgcolor"></div><span>审核</span>'+
            '<div class="yw-stepthreebgcolor"></div><span>审批</span>'+
            '<div class="yw-changebgcolor"></div><span>变更</span>'+
            '<div class="yw-logoutbgcolor"></div><span>注销</span>' +
            '</div>'

    }
})