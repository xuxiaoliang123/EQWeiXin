/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午1:31
 * To change this template use File | Settings | File Templates.
 */

Ext.define('ZSMZJ.model.manager.User', {
    extend: 'Ext.data.Model',

    fields: [
        {"name": "userid"},
        {"name": "passwd"},
        {"name": "loginname"},
        {"name": "dept"},
        {"name": "description"},
        {"name": "iplist"},
        {"name": "checkip"},
        {"name": "useful"},
        {"name": "isleader"},
        {"name": "regionid"},
        {"name": "username"},
        {"name": "owner"},
        {"name": "rate"},
        {"name": "usertype"},
        {"name": "otherinfo"},
        {"name":"createdate"},
        {"name": "roleid"}
    ]
})