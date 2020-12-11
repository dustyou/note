const common = require('./common')
const utils = require('./utils')

//css文件
require('./style.css')

common.info('hello world' + utils.add(100, 200))