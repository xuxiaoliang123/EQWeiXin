/**
 * The main application viewport, which displays the whole application
 * @extends Ext.Viewport
 */
Ext.define('ZSMZJ.view.Viewport', {
    extend: 'Ext.Viewport',
    layout: 'fit',
    requires: [
        'Ext.layout.container.Border',
        'Ext.layout.container.Accordion',
        'Ext.tab.*',
        'Ext.ux.TabCloseMenu',
        'Ext.ux.TabScrollerMenu',
        'ZSMZJ.view.MainPanel',
        'Ext.resizer.Splitter'

    ],

    initComponent: function () {
        var me = this;
        var screenwidth = 1280;
        Ext.apply(me, {

            items: [
                {
                    xtype: 'panel',
                    layout: 'border',
                    border: false,
                    items: [
                        {
                           region:"north",
                           items:[
                               Ext.create('ZSMZJ.view.Header')
                           ]
                        },
                        {
                            region:'west',
                            layout: 'fit',
                            width: 204,
                            split: false,
                            collapsible: true,
                            animCollapse: true,
                            title: '导航栏',
                            id: 'west-panel', // see Ext.getCmp() below
                            margins: '0 0 0 0',
                            layout: 'accordion',
                            items: []
                        },
                        {
                            region: "center",
                            xtype:'tabpanel',
                            width:800,
                            layout:{
                                type:'vbox',
                                align:'center'
                            },
                            id: 'mainContent-panel',

                            plugins: Ext.create('Ext.ux.TabCloseMenu', {
                                extraItemsTail: [
                                    '-',
                                    {
                                        text: 'Closable',
                                        checked: true,
                                        hideOnClick: true,
                                        handler: function (item) {
                                            currentItem.tab.setClosable(item.checked);
                                        }
                                    },
                                    '-',
                                    {
                                        text: 'Enabled',
                                        checked: true,
                                        hideOnClick: true,
                                        handler: function (item) {
                                            currentItem.tab.setDisabled(!item.checked);
                                        }
                                    }
                                ],
                                listeners: {
                                    beforemenu: function (menu, item) {
                                        var enabled = menu.child('[text="Enabled"]');
                                        menu.child('[text="Closable"]').setChecked(item.closable);
                                        if (item.tab.active) {
                                            enabled.disable();
                                        } else {
                                            enabled.enable();
                                            enabled.setChecked(!item.tab.isDisabled());
                                        }

                                        currentItem = item;
                                    }
                                }
                            }),
                            //hideMode:"visibility",
                            closeAction: 'hide',
                            activeTab: 0,     // first tab initially active
                            items: [
                                {
                                    xtype: 'mainpanel'
                                }
                            ]


                        }
                    ]
                }
            ]});

        me.callParent(arguments);
    }
});
