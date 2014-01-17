/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午1:42
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.sysUserQueryGrid', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.sysuserquerygrid',
    initComponent: function () {
        Ext.apply(this, {
                store: 'manager.Users',
                selModel: Ext.create('Ext.selection.CheckboxModel'),
                columns: [
                    Ext.create('Ext.grid.RowNumberer'),
                    {text: '简介', xtype: 'templatecolumn', width: 200, tpl: '{loginname}{username}'},
                    { text: 'loginname', dataIndex: 'loginname' } ,
                    { text: 'username', dataIndex: 'username' } ,
                    { text: 'passwd', dataIndex: 'passwd' } ,
                    { text: 'dept', dataIndex: 'dept' } ,
                    { text: 'otherinfo', dataIndex: 'otherinfo' } ,
                    { text: 'userid', dataIndex: 'userid' } ,
                    { text: 'regionid', dataIndex: 'regionid' } ,
                    { text: 'createdate', dataIndex: 'createdate', xtype: 'datecolumn', format: 'Y-m' },
                    {
                        xtype: 'actioncolumn', //8
                        width: 50,
                        items: [
                            {
                                icon: 'img/edit.png',
                                tooltip: 'Edit',
                                handler: function (grid, rowIndex, colIndex) {
                                    var rec = grid.getStore().getAt(rowIndex);
                                    Ext.MessageBox.alert('Edit', rec.get('book'));
                                }
                            },
                            {
                                icon: 'img/del.gif',
                                tooltip: 'Delete',
                                handler: function (grid, rowIndex, colIndex) {
                                    var rec = grid.getStore().getAt(rowIndex);
                                    Ext.MessageBox.alert('Delete', rec.get('book'));
                                }
                            }
                        ]
                    }
                ],
                bbar: Ext.create('Ext.PagingToolbar', {
                    store: 'manager.Users',
                    displayInfo: true,
                    displayMsg: 'Displaying topics {0} - {1} of {2}',
                    emptyMsg: "No topics to display",
                    items: [
                        '-', {
                            text: 'Show Preview',
                            enableToggle: true,
                            toggleHandler: function (btn, pressed) {

                            }
                        }]
                }),
                tbar: [
                    '->',
                    {

                        xtype:'squareshapeddiv'
                    }
                ]
            }

        )

        this.callParent(arguments);
    }


})