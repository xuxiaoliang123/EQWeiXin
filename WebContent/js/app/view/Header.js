/**
 * The application header displayed at the top of the viewport
 * @extends Ext.Component
 */
Ext.define('ZSMZJ.view.Header', {
    extend: 'Ext.Panel',
    alias : 'widget.myheader',

    requires: [
        'Ext.data.*',
        'Ext.util.*',
        'Ext.view.View'

    ],


    initComponent: function() {
        Ext.applyIf(this, {
            xtype:'panel',
            frame : false,
            layout: 'fit',
            border:false,
            height:30,
            defaults:{
                border:0
            },
            items: [
                {
                    xtype: 'component',
                    autoEl: {
                        tag: 'div',
                        html: '<div id="headerDiv">' +
                            '<div id="headerList" style="background-color:#20B2AA;">' +
                            '<ul>' +
                            '<li><a>'+loginname+'('+username+')</a></li>' +
                            '<li><a>待办(55)</a></li>' +
                            '<li><a>修改密码</a></li>' +
                            '<li><a id="logout">退出</a></li>' +
                            '</ul>'+
                            '</div>'+
                            '</div>',
                        style: {
                            border:'0px solid black',
                            backgroundColor:'#20B2AA'
                        }
                    }
                }
            ]

        });
        this.callParent(arguments);
    }
});
