/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-14
 * Time: 下午3:52
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.view.manager.JetSelect', {
    extend: 'Ext.form.ComboBox',
    alias: 'widget.jetselect',
    requires: [

    ],
    initComponent: function () {
        var me=this;
        Ext.apply(this, {
            displayField: 'aaz002',
            editable: false,
            store: (function (me) {
                var s = Ext.widget('managerjetselects');
                s.proxy.extraParams = {
                    aaz001: me.searchtype
                }
                return s;
            })(this),
            valueField: 'aaz003'

        });
        this.callParent(arguments);
    }
});