/**
 * The application header displayed at the top of the viewport
 * @extends Ext.Component
 */
Ext.define('ZSMZJ.view.MainPanel', {
    extend: 'Ext.Panel',

    alias : 'widget.mainpanel',

    requires: [


    ],
    listeners: {
        /*show: function(panel) {
            this.fireEvent('indexmsginit',this);
        }*/

    },

    initComponent: function() {
        Ext.apply(this, {
            html:'',
            //icon:'img/welcome.gif',
            id:'tabindex',
            bodyCls : ['indexbackground','welcome-title'],
            title: '首页',
            autoScroll: true

        });

        this.callParent(arguments);
    }
});
