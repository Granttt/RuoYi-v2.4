/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */
CKEDITOR.editorConfig = function( config ) {
    var base_url = "/RuoYi";
    // Define changes to default configuration here. For example:
    // config.uiColor = '#AADC6E';
    // config.entities = false;
    config.allowedContent = true ; /* 对节点的属性不进行过滤 */
    config.language = 'zh-cn';/*将编辑器的语言设置为中文*/
    config.image_previewText = ' ';/*去掉图片预览框的文字*/
    config.fontSize_defaultLabel = '16'; /*默认字体大小*/
    config.width = '99.7%';
    config.height = '600px';
    config.font_names='宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names;
    // config.extraPlugins += (config.extraPlugins ? ',lineheight' : 'lineheight');
    config.toolbarGroups = [
        { name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
        { name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
        { name: 'editing', groups: [ 'find', 'selection', 'spellchecker', 'editing' ] },
        { name: 'forms', groups: [ 'forms' ] },
        '/',
        { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
        { name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi', 'paragraph' ] },
        { name: 'links', groups: [ 'links' ] },
        { name: 'insert', groups: [ 'insert' ] },
        '/',
        { name: 'styles', groups: [ 'styles' ] },
        { name: 'colors', groups: [ 'colors' ] },
        { name: 'tools', groups: [ 'tools' ] },
        { name: 'others', groups: [ 'others' ] },
        { name: 'about', groups: [ 'about' ] }
    ];

    config.removeButtons = 'Save,NewPage,Print,SelectAll,Scayt,CreateDiv,Language,About';
    config.removePlugins = 'easyimage';
    config.extraPlugins = 'image';

    // config.filebrowserImageUploadUrl = "/file/cloudUpload";

    /*开启工具栏“图像”中文件上传功能，后面的url为图片上传要指向的的action或servlet*/
    // config.extraPlugins = 'image2'; /* 使用iamge2 */

    config.filebrowserImageUploadUrl = base_url + "/file/cloudUpload";

    config.filebrowserFlashUploadUrl = base_url + "/file/cloudUpload";

    config.imageUploadUrl = base_url + "/file/cloudUpload";

    config.uploadUrl = base_url + "/file/cloudUpload";
};
CKEDITOR.stylesSet.add( 'default', [
    /* Block Styles */
    { name : '首行缩进'	, element : 'p', styles : { 'text-indent' : '20pt' } },
    /* Inline Styles */
    { name : '标注黄色'	, element : 'span', styles : { 'background-color' : 'Yellow' } },
    { name : '标注绿色'	, element : 'span', styles : { 'background-color' : 'Lime' } },
    /* Object Styles */
    { name : '图片左对齐', element : 'img', attributes : { 'style' : 'padding: 5px; margin-right: 5px', 'border' : '2', 'align' : 'left' } },
    { name : '图片有对齐', element : 'img', attributes : { 'style' : 'padding: 5px; margin-left: 5px', 'border' : '2', 'align' : 'right' } },
    { name : '无边界表格', element : 'table', styles: { 'border-style': 'hidden', 'background-color' : '#E6E6FA' } }
]);
