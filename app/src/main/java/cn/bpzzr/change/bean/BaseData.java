package cn.bpzzr.change.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/2/23.
 * 一些基本的数据
 */

public class BaseData {

    /**
     * bossFilterConfig : [{"code":200,"name":"学历","paramName":"degree","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":207,"name":"中专及以下"},{"code":206,"name":"高中"},{"code":202,"name":"大专"},{"code":203,"name":"本科"},{"code":204,"name":"硕士"},{"code":205,"name":"博士"}]},{"code":400,"name":"薪水","paramName":"salary","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":402,"name":"3k以下"},{"code":403,"name":"3k-5k"},{"code":404,"name":"5k-10k"},{"code":405,"name":"10k-20k"},{"code":406,"name":"20k-50k"},{"code":407,"name":"50k以上"}]},{"code":100,"name":"经验","paramName":"experience","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":102,"name":"应届生"},{"code":103,"name":"1年以内"},{"code":104,"name":"1-3年"},{"code":105,"name":"3-5年"},{"code":106,"name":"5-10年"},{"code":107,"name":"10年以上"}]},{"code":700,"name":"求职意向","paramName":"intention","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":701,"name":"离职-随时到岗"},{"code":702,"name":"在职-暂不考虑"},{"code":703,"name":"在职-考虑机会"},{"code":704,"name":"在职-月内到岗"}]}]
     * city : [{"code":101010000,"firstChar":"b","name":"北京","subLevelModelList":[{"code":101010100,"firstChar":"b","name":"北京","subLevelModelList":[{"code":110101,"firstChar":"","name":"东城区"},{"code":110102,"firstChar":"","name":"西城区"},{"code":110105,"firstChar":"","name":"朝阳区"},{"code":110106,"firstChar":"","name":"丰台区"},{"code":110107,"firstChar":"","name":"石景山区"},{"code":110108,"firstChar":"","name":"海淀区"},{"code":110109,"firstChar":"","name":"门头沟区"},{"code":110111,"firstChar":"","name":"房山区"},{"code":110112,"firstChar":"","name":"通州区"},{"code":110113,"firstChar":"","name":"顺义区"},{"code":110114,"firstChar":"","name":"昌平区"},{"code":110115,"firstChar":"","name":"大兴区"},{"code":110116,"firstChar":"","name":"怀柔区"},{"code":110117,"firstChar":"","name":"平谷区"},{"code":110118,"firstChar":"","name":"密云区"},{"code":110119,"firstChar":"","name":"延庆区"}]}]},{"code":101020000,"firstChar":"s","name":"上海","subLevelModelList":[{"code":101020100,"firstChar":"s","name":"上海","subLevelModelList":[{"code":310101,"firstChar":"","name":"黄浦区"},{"code":310104,"firstChar":"","name":"徐汇区"},{"code":310105,"firstChar":"","name":"长宁区"},{"code":310106,"firstChar":"","name":"静安区"},{"code":310107,"firstChar":"","name":"普陀区"},{"code":310109,"firstChar":"","name":"虹口区"},{"code":310110,"firstChar":"","name":"杨浦区"},{"code":310112,"firstChar":"","name":"闵行区"},{"code":310113,"firstChar":"","name":"宝山区"},{"code":310114,"firstChar":"","name":"嘉定区"},{"code":310115,"firstChar":"","name":"浦东新区"},{"code":310116,"firstChar":"","name":"金山区"},{"code":310117,"firstChar":"","name":"松江区"},{"code":310118,"firstChar":"","name":"青浦区"},{"code":310120,"firstChar":"","name":"奉贤区"},{"code":310230,"firstChar":"","name":"崇明县"}]}]},{"code":101030000,"firstChar":"t","name":"天津","subLevelModelList":[{"code":101030100,"firstChar":"t","name":"天津","subLevelModelList":[{"code":120101,"firstChar":"","name":"和平区"},{"code":120102,"firstChar":"","name":"河东区"},{"code":120103,"firstChar":"","name":"河西区"},{"code":120104,"firstChar":"","name":"南开区"},{"code":120105,"firstChar":"","name":"河北区"},{"code":120106,"firstChar":"","name":"红桥区"},{"code":120110,"firstChar":"","name":"东丽区"},{"code":120111,"firstChar":"","name":"西青区"},{"code":120112,"firstChar":"","name":"津南区"},{"code":120113,"firstChar":"","name":"北辰区"},{"code":120114,"firstChar":"","name":"武清区"},{"code":120115,"firstChar":"","name":"宝坻区"},{"code":120116,"firstChar":"","name":"滨海新区"},{"code":120117,"firstChar":"","name":"宁河区"},{"code":120118,"firstChar":"","name":"静海区"},{"code":120225,"firstChar":"","name":"蓟县"}]}]},{"code":101040000,"firstChar":"c","name":"重庆","subLevelModelList":[{"code":101040100,"firstChar":"c","name":"重庆","subLevelModelList":[{"code":500101,"firstChar":"","name":"万州区"},{"code":500102,"firstChar":"","name":"涪陵区"},{"code":500103,"firstChar":"","name":"渝中区"},{"code":500104,"firstChar":"","name":"大渡口区"},{"code":500105,"firstChar":"","name":"江北区"},{"code":500106,"firstChar":"","name":"沙坪坝区"},{"code":500107,"firstChar":"","name":"九龙坡区"},{"code":500108,"firstChar":"","name":"南岸区"},{"code":500109,"firstChar":"","name":"北碚区"},{"code":500110,"firstChar":"","name":"綦江区"},{"code":500111,"firstChar":"","name":"大足区"},{"code":500112,"firstChar":"","name":"渝北区"},{"code":500113,"firstChar":"","name":"巴南区"},{"code":500114,"firstChar":"","name":"黔江区"},{"code":500115,"firstChar":"","name":"长寿区"},{"code":500116,"firstChar":"","name":"江津区"},{"code":500117,"firstChar":"","name":"合川区"},{"code":500118,"firstChar":"","name":"永川区"},{"code":500119,"firstChar":"","name":"南川区"},{"code":500120,"firstChar":"","name":"璧山区"},{"code":500151,"firstChar":"","name":"铜梁区"},{"code":500152,"firstChar":"","name":"潼南区"},{"code":500153,"firstChar":"","name":"荣昌区"},{"code":500228,"firstChar":"","name":"梁平县"},{"code":500229,"firstChar":"","name":"城口县"},{"code":500230,"firstChar":"","name":"丰都县"},{"code":500231,"firstChar":"","name":"垫江县"},{"code":500232,"firstChar":"","name":"武隆县"},{"code":500233,"firstChar":"","name":"忠县"},{"code":500234,"firstChar":"","name":"开州区"},{"code":500235,"firstChar":"","name":"云阳县"},{"code":500236,"firstChar":"","name":"奉节县"},{"code":500237,"firstChar":"","name":"巫山县"},{"code":500238,"firstChar":"","name":"巫溪县"},{"code":500240,"firstChar":"","name":"石柱土家族自治县"},{"code":500241,"firstChar":"","name":"秀山土家族苗族自治县"},{"code":500242,"firstChar":"","name":"酉阳土家族苗族自治县"},{"code":500243,"firstChar":"","name":"彭水苗族土家族自治县"}]}]},{"code":101050000,"firstChar":"h","name":"黑龙江","subLevelModelList":[{"code":101050100,"firstChar":"h","name":"哈尔滨","subLevelModelList":[{"code":230102,"firstChar":"","name":"道里区"},{"code":230103,"firstChar":"","name":"南岗区"},{"code":230104,"firstChar":"","name":"道外区"},{"code":230108,"firstChar":"","name":"平房区"},{"code":230109,"firstChar":"","name":"松北区"},{"code":230110,"firstChar":"","name":"香坊区"},{"code":230111,"firstChar":"","name":"呼兰区"},{"code":230112,"firstChar":"","name":"阿城区"},{"code":230113,"firstChar":"","name":"双城区"},{"code":230123,"firstChar":"","name":"依兰县"},{"code":230124,"firstChar":"","name":"方正县"},{"code":230125,"firstChar":"","name":"宾县"},{"code":230126,"firstChar":"","name":"巴彦县"},{"code":230127,"firstChar":"","name":"木兰县"},{"code":230128,"firstChar":"","name":"通河县"},{"code":230129,"firstChar":"","name":"延寿县"},{"code":230183,"firstChar":"","name":"尚志市"},{"code":230184,"firstChar":"","name":"五常市"}]},{"code":101050200,"firstChar":"q","name":"齐齐哈尔","subLevelModelList":[{"code":230202,"firstChar":"","name":"龙沙区"},{"code":230203,"firstChar":"","name":"建华区"},{"code":230204,"firstChar":"","name":"铁锋区"},{"code":230205,"firstChar":"","name":"昂昂溪区"},{"code":230206,"firstChar":"","name":"富拉尔基区"},{"code":230207,"firstChar":"","name":"碾子山区"},{"code":230208,"firstChar":"","name":"梅里斯达斡尔族区"},{"code":230221,"firstChar":"","name":"龙江县"},{"code":230223,"firstChar":"","name":"依安县"},{"code":230224,"firstChar":"","name":"泰来县"},{"code":230225,"firstChar":"","name":"甘南县"},{"code":230227,"firstChar":"","name":"富裕县"},{"code":230229,"firstChar":"","name":"克山县"},{"code":230230,"firstChar":"","name":"克东县"},{"code":230231,"firstChar":"","name":"拜泉县"},{"code":230281,"firstChar":"","name":"讷河市"}]},{"code":101050300,"firstChar":"m","name":"牡丹江","subLevelModelList":[{"code":231002,"firstChar":"","name":"东安区"},{"code":231003,"firstChar":"","name":"阳明区"},{"code":231004,"firstChar":"","name":"爱民区"},{"code":231005,"firstChar":"","name":"西安区"},{"code":231086,"firstChar":"","name":"东宁市"},{"code":231025,"firstChar":"","name":"林口县"},{"code":231081,"firstChar":"","name":"绥芬河市"},{"code":231083,"firstChar":"","name":"海林市"},{"code":231084,"firstChar":"","name":"宁安市"},{"code":231085,"firstChar":"","name":"穆棱市"}]},{"code":101050400,"firstChar":"j","name":"佳木斯","subLevelModelList":[{"code":230803,"firstChar":"","name":"向阳区"},{"code":230804,"firstChar":"","name":"前进区"},{"code":230805,"firstChar":"","name":"东风区"},{"code":230811,"firstChar":"","name":"郊区"},{"code":230822,"firstChar":"","name":"桦南县"},{"code":230826,"firstChar":"","name":"桦川县"},{"code":230828,"firstChar":"","name":"汤原县"},{"code":230833,"firstChar":"","name":"抚远市"},{"code":230881,"firstChar":"","name":"同江市"},{"code":230882,"firstChar":"","name":"富锦市"}]},{"code":101050500,"firstChar":"s","name":"绥化","subLevelModelList":[{"code":231202,"firstChar":"","name":"北林区"},{"code":231221,"firstChar":"","name":"望奎县"},{"code":231222,"firstChar":"","name":"兰西县"},{"code":231223,"firstChar":"","name":"青冈县"},{"code":231224,"firstChar":"","name":"庆安县"},{"code":231225,"firstChar":"","name":"明水县"},{"code":231226,"firstChar":"","name":"绥棱县"},{"code":231281,"firstChar":"","name":"安达市"},{"code":231282,"firstChar":"","name":"肇东市"},{"code":231283,"firstChar":"","name":"海伦市"}]},{"code":101050600,"firstChar":"h","name":"黑河","subLevelModelList":[{"code":231102,"firstChar":"","name":"爱辉区"},{"code":231121,"firstChar":"","name":"嫩江县"},{"code":231123,"firstChar":"","name":"逊克县"},{"code":231124,"firstChar":"","name":"孙吴县"},{"code":231181,"firstChar":"","name":"北安市"},{"code":231182,"firstChar":"","name":"五大连池市"}]},{"code":101050700,"firstChar":"y","name":"伊春","subLevelModelList":[{"code":230703,"firstChar":"","name":"南岔区"},{"code":230704,"firstChar":"","name":"友好区"},{"code":230705,"firstChar":"","name":"西林区"},{"code":230706,"firstChar":"","name":"翠峦区"},{"code":230707,"firstChar":"","name":"新青区"},{"code":230708,"firstChar":"","name":"美溪区"},{"code":230709,"firstChar":"","name":"金山屯区"},{"code":230710,"firstChar":"","name":"五营区"},{"code":230711,"firstChar":"","name":"乌马河区"},{"code":230712,"firstChar":"","name":"汤旺河区"},{"code":230713,"firstChar":"","name":"带岭区"},{"code":230714,"firstChar":"","name":"乌伊岭区"},{"code":230715,"firstChar":"","name":"红星区"},{"code":230716,"firstChar":"","name":"上甘岭区"},{"code":230722,"firstChar":"","name":"嘉荫县"},{"code":230781,"firstChar":"","name":"铁力市"}]},{"code":101050800,"firstChar":"d","name":"大庆","subLevelModelList":[{"code":230602,"firstChar":"","name":"萨尔图区"},{"code":230603,"firstChar":"","name":"龙凤区"},{"code":230604,"firstChar":"","name":"让胡路区"},{"code":230605,"firstChar":"","name":"红岗区"},{"code":230606,"firstChar":"","name":"大同区"},{"code":230621,"firstChar":"","name":"肇州县"},{"code":230622,"firstChar":"","name":"肇源县"},{"code":230623,"firstChar":"","name":"林甸县"},{"code":230624,"firstChar":"","name":"杜尔伯特蒙古族自治县"}]},{"code":101050900,"firstChar":"q","name":"七台河","subLevelModelList":[{"code":230902,"firstChar":"","name":"新兴区"},{"code":230903,"firstChar":"","name":"桃山区"},{"code":230904,"firstChar":"","name":"茄子河区"},{"code":230921,"firstChar":"","name":"勃利县"}]},{"code":101051000,"firstChar":"j","name":"鸡西","subLevelModelList":[{"code":230302,"firstChar":"","name":"鸡冠区"},{"code":230303,"firstChar":"","name":"恒山区"},{"code":230304,"firstChar":"","name":"滴道区"},{"code":230305,"firstChar":"","name":"梨树区"},{"code":230306,"firstChar":"","name":"城子河区"},{"code":230307,"firstChar":"","name":"麻山区"},{"code":230321,"firstChar":"","name":"鸡东县"},{"code":230381,"firstChar":"","name":"虎林市"},{"code":230382,"firstChar":"","name":"密山市"}]},{"code":101051100,"firstChar":"h","name":"鹤岗","subLevelModelList":[{"code":230402,"firstChar":"","name":"向阳区"},{"code":230403,"firstChar":"","name":"工农区"},{"code":230404,"firstChar":"","name":"南山区"},{"code":230405,"firstChar":"","name":"兴安区"},{"code":230406,"firstChar":"","name":"东山区"},{"code":230407,"firstChar":"","name":"兴山区"},{"code":230421,"firstChar":"","name":"萝北县"},{"code":230422,"firstChar":"","name":"绥滨县"}]},{"code":101051200,"firstChar":"s","name":"双鸭山","subLevelModelList":[{"code":230502,"firstChar":"","name":"尖山区"},{"code":230503,"firstChar":"","name":"岭东区"},{"code":230505,"firstChar":"","name":"四方台区"},{"code":230506,"firstChar":"","name":"宝山区"},{"code":230521,"firstChar":"","name":"集贤县"},{"code":230522,"firstChar":"","name":"友谊县"},{"code":230523,"firstChar":"","name":"宝清县"},{"code":230524,"firstChar":"","name":"饶河县"}]}]},{"code":101060000,"firstChar":"j","name":"吉林","subLevelModelList":[{"code":101060100,"firstChar":"c","name":"长春","subLevelModelList":[{"code":220102,"firstChar":"","name":"南关区"},{"code":220103,"firstChar":"","name":"宽城区"},{"code":220104,"firstChar":"","name":"朝阳区"},{"code":220105,"firstChar":"","name":"二道区"},{"code":220106,"firstChar":"","name":"绿园区"},{"code":220112,"firstChar":"","name":"双阳区"},{"code":220113,"firstChar":"","name":"九台区"},{"code":220122,"firstChar":"","name":"农安县"},{"code":220182,"firstChar":"","name":"榆树市"},{"code":220183,"firstChar":"","name":"德惠市"}]},{"code":101060200,"firstChar":"j","name":"吉林","subLevelModelList":[{"code":220202,"firstChar":"","name":"昌邑区"},{"code":220203,"firstChar":"","name":"龙潭区"},{"code":220204,"firstChar":"","name":"船营区"},{"code":220211,"firstChar":"","name":"丰满区"},{"code":220221,"firstChar":"","name":"永吉县"},{"code":220281,"firstChar":"","name":"蛟河市"},{"code":220282,"firstChar":"","name":"桦甸市"},{"code":220283,"firstChar":"","name":"舒兰市"},{"code":220284,"firstChar":"","name":"磐石市"}]},{"code":101060300,"firstChar":"s","name":"四平","subLevelModelList":[{"code":220302,"firstChar":"","name":"铁西区"},{"code":220303,"firstChar":"","name":"铁东区"},{"code":220322,"firstChar":"","name":"梨树县"},{"code":220323,"firstChar":"","name":"伊通满族自治县"},{"code":220381,"firstChar":"","name":"公主岭市"},{"code":220382,"firstChar":"","name":"双辽市"}]},{"code":101060400,"firstChar":"t","name":"通化","subLevelModelList":[{"code":220502,"firstChar":"","name":"东昌区"},{"code":220503,"firstChar":"","name":"二道江区"},{"code":220523,"firstChar":"","name":"辉南县"},{"code":220524,"firstChar":"","name":"柳河县"},{"code":220581,"firstChar":"","name":"梅河口市"},{"code":220582,"firstChar":"","name":"集安市"}]},{"code":101060500,"firstChar":"b","name":"白城","subLevelModelList":[{"code":220802,"firstChar":"","name":"洮北区"},{"code":220821,"firstChar":"","name":"镇赉县"},{"code":220822,"firstChar":"","name":"通榆县"},{"code":220881,"firstChar":"","name":"洮南市"},{"code":220882,"firstChar":"","name":"大安市"}]},{"code":101060600,"firstChar":"l","name":"辽源","subLevelModelList":[{"code":220402,"firstChar":"","name":"龙山区"},{"code":220403,"firstChar":"","name":"西安区"},{"code":220421,"firstChar":"","name":"东丰县"},{"code":220422,"firstChar":"","name":"东辽县"}]},{"code":101060700,"firstChar":"s","name":"松原","subLevelModelList":[{"code":220702,"firstChar":"","name":"宁江区"},{"code":220721,"firstChar":"","name":"前郭尔罗斯蒙古族自治县"},{"code":220722,"firstChar":"","name":"长岭县"},{"code":220723,"firstChar":"","name":"乾安县"},{"code":220781,"firstChar":"","name":"扶余市"}]},{"code":101060800,"firstChar":"b","name":"白山","subLevelModelList":[{"code":220602,"firstChar":"","name":"浑江区"},{"code":220605,"firstChar":"","name":"江源区"},{"code":220621,"firstChar":"","name":"抚松县"},{"code":220622,"firstChar":"","name":"靖宇县"},{"code":220623,"firstChar":"","name":"长白朝鲜族自治县"},{"code":220681,"firstChar":"","name":"临江市"}]},{"code":101060900,"firstChar":"y","name":"延边","subLevelModelList":[{"code":222401,"firstChar":"","name":"延吉市"},{"code":222402,"firstChar":"","name":"图们市"},{"code":222403,"firstChar":"","name":"敦化市"},{"code":222404,"firstChar":"","name":"珲春市"},{"code":222405,"firstChar":"","name":"龙井市"},{"code":222406,"firstChar":"","name":"和龙市"},{"code":222424,"firstChar":"","name":"汪清县"},{"code":222426,"firstChar":"","name":"安图县"}]}]},{"code":101070000,"firstChar":"l","name":"辽宁","subLevelModelList":[{"code":101070100,"firstChar":"s","name":"沈阳","subLevelModelList":[{"code":210102,"firstChar":"","name":"和平区"},{"code":210103,"firstChar":"","name":"沈河区"},{"code":210104,"firstChar":"","name":"大东区"},{"code":210105,"firstChar":"","name":"皇姑区"},{"code":210106,"firstChar":"","name":"铁西区"},{"code":210111,"firstChar":"","name":"苏家屯区"},{"code":210112,"firstChar":"","name":"浑南区"},{"code":210113,"firstChar":"","name":"沈北新区"},{"code":210114,"firstChar":"","name":"于洪区"},{"code":210115,"firstChar":"","name":"辽中区"},{"code":210123,"firstChar":"","name":"康平县"},{"code":210124,"firstChar":"","name":"法库县"},{"code":210181,"firstChar":"","name":"新民市"}]},{"code":101070200,"firstChar":"d","name":"大连","subLevelModelList":[{"code":210202,"firstChar":"","name":"中山区"},{"code":210203,"firstChar":"","name":"西岗区"},{"code":210204,"firstChar":"","name":"沙河口区"},{"code":210211,"firstChar":"","name":"甘井子区"},{"code":210212,"firstChar":"","name":"旅顺口区"},{"code":210213,"firstChar":"","name":"金州区"},{"code":210224,"firstChar":"","name":"长海县"},{"code":210281,"firstChar":"","name":"瓦房店市"},{"code":210214,"firstChar":"","name":"普兰店区"},{"code":210283,"firstChar":"","name":"庄河市"}]},{"code":101070300,"firstChar":"a","name":"鞍山","subLevelModelList":[{"code":210302,"firstChar":"","name":"铁东区"},{"code":210303,"firstChar":"","name":"铁西区"},{"code":210304,"firstChar":"","name":"立山区"},{"code":210311,"firstChar":"","name":"千山区"},{"code":210321,"firstChar":"","name":"台安县"},{"code":210323,"firstChar":"","name":"岫岩满族自治县"},{"code":210381,"firstChar":"","name":"海城市"}]},{"code":101070400,"firstChar":"f","name":"抚顺","subLevelModelList":[{"code":210402,"firstChar":"","name":"新抚区"},{"code":210403,"firstChar":"","name":"东洲区"},{"code":210404,"firstChar":"","name":"望花区"},{"code":210411,"firstChar":"","name":"顺城区"},{"code":210422,"firstChar":"","name":"新宾满族自治县"},{"code":210423,"firstChar":"","name":"清原满族自治县"}]},{"code":101070500,"firstChar":"b","name":"本溪","subLevelModelList":[{"code":210502,"firstChar":"","name":"平山区"},{"code":210503,"firstChar":"","name":"溪湖区"},{"code":210504,"firstChar":"","name":"明山区"},{"code":210505,"firstChar":"","name":"南芬区"},{"code":210522,"firstChar":"","name":"桓仁满族自治县"}]},{"code":101070600,"firstChar":"d","name":"丹东","subLevelModelList":[{"code":210602,"firstChar":"","name":"元宝区"},{"code":210603,"firstChar":"","name":"振兴区"},{"code":210604,"firstChar":"","name":"振安区"},{"code":210624,"firstChar":"","name":"宽甸满族自治县"},{"code":210681,"firstChar":"","name":"东港市"},{"code":210682,"firstChar":"","name":"凤城市"}]},{"code":101070700,"firstChar":"j","name":"锦州","subLevelModelList":[{"code":210702,"firstChar":"","name":"古塔区"},{"code":210703,"firstChar":"","name":"凌河区"},{"code":210711,"firstChar":"","name":"太和区"},{"code":210726,"firstChar":"","name":"黑山县"},{"code":210727,"firstChar":"","name":"义县"},{"code":210781,"firstChar":"","name":"凌海市"},{"code":210782,"firstChar":"","name":"北镇市"}]},{"code":101070800,"firstChar":"y","name":"营口","subLevelModelList":[{"code":210802,"firstChar":"","name":"站前区"},{"code":210803,"firstChar":"","name":"西市区"},{"code":210804,"firstChar":"","name":"鲅鱼圈区"},{"code":210811,"firstChar":"","name":"老边区"},{"code":210881,"firstChar":"","name":"盖州市"},{"code":210882,"firstChar":"","name":"大石桥市"}]},{"code":101070900,"firstChar":"f","name":"阜新","subLevelModelList":[{"code":210902,"firstChar":"","name":"海州区"},{"code":210903,"firstChar":"","name":"新邱区"},{"code":210904,"firstChar":"","name":"太平区"},{"code":210905,"firstChar":"","name":"清河门区"},{"code":210911,"firstChar":"","name":"细河区"},{"code":210922,"firstChar":"","name":"彰武县"}]},{"code":101071000,"firstChar":"l","name":"辽阳","subLevelModelList":[{"code":211002,"firstChar":"","name":"白塔区"},{"code":211003,"firstChar":"","name":"文圣区"},{"code":211004,"firstChar":"","name":"宏伟区"},{"code":211005,"firstChar":"","name":"弓长岭区"},{"code":211011,"firstChar":"","name":"太子河区"},{"code":211081,"firstChar":"","name":"灯塔市"}]},{"code":101071100,"firstChar":"t","name":"铁岭","subLevelModelList":[{"code":211202,"firstChar":"","name":"银州区"},{"code":211204,"firstChar":"","name":"清河区"},{"code":211223,"firstChar":"","name":"西丰县"},{"code":211224,"firstChar":"","name":"昌图县"},{"code":211281,"firstChar":"","name":"调兵山市"},{"code":211282,"firstChar":"","name":"开原市"}]},{"code":101071200,"firstChar":"c","name":"朝阳","subLevelModelList":[{"code":211302,"firstChar":"","name":"双塔区"},{"code":211303,"firstChar":"","name":"龙城区"},{"code":211322,"firstChar":"","name":"建平县"},{"code":211324,"firstChar":"","name":"喀喇沁左翼蒙古族自治县"},{"code":211381,"firstChar":"","name":"北票市"},{"code":211382,"firstChar":"","name":"凌源市"}]},{"code":101071300,"firstChar":"p","name":"盘锦","subLevelModelList":[{"code":211102,"firstChar":"","name":"双台子区"},{"code":211103,"firstChar":"","name":"兴隆台区"},{"code":211121,"firstChar":"","name":"大洼区"},{"code":211122,"firstChar":"","name":"盘山县"}]},{"code":101071400,"firstChar":"h","name":"葫芦岛","subLevelModelList":[{"code":211402,"firstChar":"","name":"连山区"},{"code":211403,"firstChar":"","name":"龙港区"},{"code":211404,"firstChar":"","name":"南票区"},{"code":211421,"firstChar":"","name":"绥中县"},{"code":211422,"firstChar":"","name":"建昌县"},{"code":211481,"firstChar":"","name":"兴城市"}]}]},{"code":101080000,"firstChar":"n","name":"内蒙古","subLevelModelList":[{"code":101080100,"firstChar":"h","name":"呼和浩特","subLevelModelList":[{"code":150102,"firstChar":"","name":"新城区"},{"code":150103,"firstChar":"","name":"回民区"},{"code":150104,"firstChar":"","name":"玉泉区"},{"code":150105,"firstChar":"","name":"赛罕区"},{"code":150121,"firstChar":"","name":"土默特左旗"},{"code":150122,"firstChar":"","name":"托克托县"},{"code":150123,"firstChar":"","name":"和林格尔县"},{"code":150124,"firstChar":"","name":"清水河县"},{"code":150125,"firstChar":"","name":"武川县"}]},{"code":101080200,"firstChar":"b","name":"包头","subLevelModelList":[{"code":150202,"firstChar":"","name":"东河区"},{"code":150203,"firstChar":"","name":"昆都仑区"},{"code":150204,"firstChar":"","name":"青山区"},{"code":150205,"firstChar":"","name":"石拐区"},{"code":150206,"firstChar":"","name":"白云鄂博矿区"},{"code":150207,"firstChar":"","name":"九原区"},{"code":150221,"firstChar":"","name":"土默特右旗"},{"code":150222,"firstChar":"","name":"固阳县"},{"code":150223,"firstChar":"","name":"达尔罕茂明安联合旗"}]},{"code":101080300,"firstChar":"w","name":"乌海","subLevelModelList":[{"code":150302,"firstChar":"","name":"海勃湾区"},{"code":150303,"firstChar":"","name":"海南区"},{"code":150304,"firstChar":"","name":"乌达区"}]},{"code":101080400,"firstChar":"t","name":"通辽","subLevelModelList":[{"code":150502,"firstChar":"","name":"科尔沁区"},{"code":150521,"firstChar":"","name":"科尔沁左翼中旗"},{"code":150522,"firstChar":"","name":"科尔沁左翼后旗"},{"code":150523,"firstChar":"","name":"开鲁县"},{"code":150524,"firstChar":"","name":"库伦旗"},{"code":150525,"firstChar":"","name":"奈曼旗"},{"code":150526,"firstChar":"","name":"扎鲁特旗"},{"code":150581,"firstChar":"","name":"霍林郭勒市"}]},{"code":101080500,"firstChar":"c","name":"赤峰","subLevelModelList":[{"code":150402,"firstChar":"","name":"红山区"},{"code":150403,"firstChar":"","name":"元宝山区"},{"code":150404,"firstChar":"","name":"松山区"},{"code":150421,"firstChar":"","name":"阿鲁科尔沁旗"},{"code":150422,"firstChar":"","name":"巴林左旗"},{"code":150423,"firstChar":"","name":"巴林右旗"},{"code":150424,"firstChar":"","name":"林西县"},{"code":150425,"firstChar":"","name":"克什克腾旗"},{"code":150426,"firstChar":"","name":"翁牛特旗"},{"code":150428,"firstChar":"","name":"喀喇沁旗"},{"code":150429,"firstChar":"","name":"宁城县"},{"code":150430,"firstChar":"","name":"敖汉旗"}]},{"code":101080600,"firstChar":"e","name":"鄂尔多斯","subLevelModelList":[{"code":150602,"firstChar":"","name":"东胜区"},{"code":150603,"firstChar":"","name":"康巴什区"},{"code":150621,"firstChar":"","name":"达拉特旗"},{"code":150622,"firstChar":"","name":"准格尔旗"},{"code":150623,"firstChar":"","name":"鄂托克前旗"},{"code":150624,"firstChar":"","name":"鄂托克旗"},{"code":150625,"firstChar":"","name":"杭锦旗"},{"code":150626,"firstChar":"","name":"乌审旗"},{"code":150627,"firstChar":"","name":"伊金霍洛旗"}]},{"code":101080700,"firstChar":"h","name":"呼伦贝尔","subLevelModelList":[{"code":150702,"firstChar":"","name":"海拉尔区"},{"code":150703,"firstChar":"","name":"扎赉诺尔区"},{"code":150721,"firstChar":"","name":"阿荣旗"},{"code":150722,"firstChar":"","name":"莫力达瓦达斡尔族自治旗"},{"code":150723,"firstChar":"","name":"鄂伦春自治旗"},{"code":150724,"firstChar":"","name":"鄂温克族自治旗"},{"code":150725,"firstChar":"","name":"陈巴尔虎旗"},{"code":150726,"firstChar":"","name":"新巴尔虎左旗"},{"code":150727,"firstChar":"","name":"新巴尔虎右旗"},{"code":150781,"firstChar":"","name":"满洲里市"},{"code":150782,"firstChar":"","name":"牙克石市"},{"code":150783,"firstChar":"","name":"扎兰屯市"},{"code":150784,"firstChar":"","name":"额尔古纳市"},{"code":150785,"firstChar":"","name":"根河市"}]},{"code":101080800,"firstChar":"b","name":"巴彦淖尔","subLevelModelList":[{"code":150802,"firstChar":"","name":"临河区"},{"code":150821,"firstChar":"","name":"五原县"},{"code":150822,"firstChar":"","name":"磴口县"},{"code":150823,"firstChar":"","name":"乌拉特前旗"},{"code":150824,"firstChar":"","name":"乌拉特中旗"},{"code":150825,"firstChar":"","name":"乌拉特后旗"},{"code":150826,"firstChar":"","name":"杭锦后旗"}]},{"code":101080900,"firstChar":"w","name":"乌兰察布","subLevelModelList":[{"code":150902,"firstChar":"","name":"集宁区"},{"code":150921,"firstChar":"","name":"卓资县"},{"code":150922,"firstChar":"","name":"化德县"},{"code":150923,"firstChar":"","name":"商都县"},{"code":150924,"firstChar":"","name":"兴和县"},{"code":150925,"firstChar":"","name":"凉城县"},{"code":150926,"firstChar":"","name":"察哈尔右翼前旗"},{"code":150927,"firstChar":"","name":"察哈尔右翼中旗"},{"code":150928,"firstChar":"","name":"察哈尔右翼后旗"},{"code":150929,"firstChar":"","name":"四子王旗"},{"code":150981,"firstChar":"","name":"丰镇市"}]},{"code":101081000,"firstChar":"x","name":"锡林郭勒","subLevelModelList":[{"code":152501,"firstChar":"","name":"二连浩特市"},{"code":152502,"firstChar":"","name":"锡林浩特市"},{"code":152522,"firstChar":"","name":"阿巴嘎旗"},{"code":152523,"firstChar":"","name":"苏尼特左旗"},{"code":152524,"firstChar":"","name":"苏尼特右旗"},{"code":152525,"firstChar":"","name":"东乌珠穆沁旗"},{"code":152526,"firstChar":"","name":"西乌珠穆沁旗"},{"code":152527,"firstChar":"","name":"太仆寺旗"},{"code":152528,"firstChar":"","name":"镶黄旗"},{"code":152529,"firstChar":"","name":"正镶白旗"},{"code":152530,"firstChar":"","name":"正蓝旗"},{"code":152531,"firstChar":"","name":"多伦县"}]}]},{"code":101090000,"firstChar":"h","name":"河北","subLevelModelList":[{"code":101090100,"firstChar":"s","name":"石家庄","subLevelModelList":[{"code":130102,"firstChar":"","name":"长安区"},{"code":130104,"firstChar":"","name":"桥西区"},{"code":130105,"firstChar":"","name":"新华区"},{"code":130107,"firstChar":"","name":"井陉矿区"},{"code":130108,"firstChar":"","name":"裕华区"},{"code":130109,"firstChar":"","name":"藁城区"},{"code":130110,"firstChar":"","name":"鹿泉区"},{"code":130111,"firstChar":"","name":"栾城区"},{"code":130121,"firstChar":"","name":"井陉县"},{"code":130123,"firstChar":"","name":"正定县"},{"code":130125,"firstChar":"","name":"行唐县"},{"code":130126,"firstChar":"","name":"灵寿县"},{"code":130127,"firstChar":"","name":"高邑县"},{"code":130128,"firstChar":"","name":"深泽县"},{"code":130129,"firstChar":"","name":"赞皇县"},{"code":130130,"firstChar":"","name":"无极县"},{"code":130131,"firstChar":"","name":"平山县"},{"code":130132,"firstChar":"","name":"元氏县"},{"code":130133,"firstChar":"","name":"赵县"},{"code":130181,"firstChar":"","name":"辛集市"},{"code":130183,"firstChar":"","name":"晋州市"},{"code":130184,"firstChar":"","name":"新乐市"}]},{"code":101090200,"firstChar":"b","name":"保定","subLevelModelList":[{"code":130602,"firstChar":"","name":"竞秀区"},{"code":130606,"firstChar":"","name":"莲池区"},{"code":130607,"firstChar":"","name":"满城区"},{"code":130608,"firstChar":"","name":"清苑区"},{"code":130623,"firstChar":"","name":"涞水县"},{"code":130624,"firstChar":"","name":"阜平县"},{"code":130609,"firstChar":"","name":"徐水区"},{"code":130626,"firstChar":"","name":"定兴县"},{"code":130627,"firstChar":"","name":"唐县"},{"code":130628,"firstChar":"","name":"高阳县"},{"code":130629,"firstChar":"","name":"容城县"},{"code":130630,"firstChar":"","name":"涞源县"},{"code":130631,"firstChar":"","name":"望都县"},{"code":130632,"firstChar":"","name":"安新县"},{"code":130633,"firstChar":"","name":"易县"},{"code":130634,"firstChar":"","name":"曲阳县"},{"code":130635,"firstChar":"","name":"蠡县"},{"code":130636,"firstChar":"","name":"顺平县"},{"code":130637,"firstChar":"","name":"博野县"},{"code":130638,"firstChar":"","name":"雄县"},{"code":130681,"firstChar":"","name":"涿州市"},{"code":130682,"firstChar":"","name":"定州市"},{"code":130683,"firstChar":"","name":"安国市"},{"code":130684,"firstChar":"","name":"高碑店市"}]},{"code":101090300,"firstChar":"z","name":"张家口","subLevelModelList":[{"code":130702,"firstChar":"","name":"桥东区"},{"code":130703,"firstChar":"","name":"桥西区"},{"code":130705,"firstChar":"","name":"宣化区"},{"code":130706,"firstChar":"","name":"下花园区"},{"code":130722,"firstChar":"","name":"张北县"},{"code":130723,"firstChar":"","name":"康保县"},{"code":130724,"firstChar":"","name":"沽源县"},{"code":130725,"firstChar":"","name":"尚义县"},{"code":130726,"firstChar":"","name":"蔚县"},{"code":130727,"firstChar":"","name":"阳原县"},{"code":130728,"firstChar":"","name":"怀安县"},{"code":130729,"firstChar":"","name":"万全区"},{"code":130730,"firstChar":"","name":"怀来县"},{"code":130731,"firstChar":"","name":"涿鹿县"},{"code":130732,"firstChar":"","name":"赤城县"},{"code":130733,"firstChar":"","name":"崇礼区"}]},{"code":101090400,"firstChar":"c","name":"承德","subLevelModelList":[{"code":130802,"firstChar":"","name":"双桥区"},{"code":130803,"firstChar":"","name":"双滦区"},{"code":130804,"firstChar":"","name":"鹰手营子矿区"},{"code":130822,"firstChar":"","name":"兴隆县"},{"code":130823,"firstChar":"","name":"平泉县"},{"code":130824,"firstChar":"","name":"滦平县"},{"code":130825,"firstChar":"","name":"隆化县"},{"code":130826,"firstChar":"","name":"丰宁满族自治县"},{"code":130827,"firstChar":"","name":"宽城满族自治县"},{"code":130828,"firstChar":"","name":"围场满族蒙古族自治县"}]},{"code":101090500,"firstChar":"t","name":"唐山","subLevelModelList":[{"code":130202,"firstChar":"","name":"路南区"},{"code":130203,"firstChar":"","name":"路北区"},{"code":130204,"firstChar":"","name":"古冶区"},{"code":130205,"firstChar":"","name":"开平区"},{"code":130207,"firstChar":"","name":"丰南区"},{"code":130208,"firstChar":"","name":"丰润区"},{"code":130209,"firstChar":"","name":"曹妃甸区"},{"code":130223,"firstChar":"","name":"滦县"},{"code":130224,"firstChar":"","name":"滦南县"},{"code":130225,"firstChar":"","name":"乐亭县"},{"code":130227,"firstChar":"","name":"迁西县"},{"code":130229,"firstChar":"","name":"玉田县"},{"code":130281,"firstChar":"","name":"遵化市"},{"code":130283,"firstChar":"","name":"迁安市"}]},{"code":101090600,"firstChar":"l","name":"廊坊","subLevelModelList":[{"code":131002,"firstChar":"","name":"安次区"},{"code":131003,"firstChar":"","name":"广阳区"},{"code":131022,"firstChar":"","name":"固安县"},{"code":131023,"firstChar":"","name":"永清县"},{"code":131024,"firstChar":"","name":"香河县"},{"code":131025,"firstChar":"","name":"大城县"},{"code":131026,"firstChar":"","name":"文安县"},{"code":131028,"firstChar":"","name":"大厂回族自治县"},{"code":131081,"firstChar":"","name":"霸州市"},{"code":131082,"firstChar":"","name":"三河市"}]},{"code":101090700,"firstChar":"c","name":"沧州","subLevelModelList":[{"code":130902,"firstChar":"","name":"新华区"},{"code":130903,"firstChar":"","name":"运河区"},{"code":130921,"firstChar":"","name":"沧县"},{"code":130922,"firstChar":"","name":"青县"},{"code":130923,"firstChar":"","name":"东光县"},{"code":130924,"firstChar":"","name":"海兴县"},{"code":130925,"firstChar":"","name":"盐山县"},{"code":130926,"firstChar":"","name":"肃宁县"},{"code":130927,"firstChar":"","name":"南皮县"},{"code":130928,"firstChar":"","name":"吴桥县"},{"code":130929,"firstChar":"","name":"献县"},{"code":130930,"firstChar":"","name":"孟村回族自治县"},{"code":130981,"firstChar":"","name":"泊头市"},{"code":130982,"firstChar":"","name":"任丘市"},{"code":130983,"firstChar":"","name":"黄骅市"},{"code":130984,"firstChar":"","name":"河间市"}]},{"code":101090800,"firstChar":"h","name":"衡水","subLevelModelList":[{"code":131102,"firstChar":"","name":"桃城区"},{"code":131121,"firstChar":"","name":"枣强县"},{"code":131122,"firstChar":"","name":"武邑县"},{"code":131123,"firstChar":"","name":"武强县"},{"code":131124,"firstChar":"","name":"饶阳县"},{"code":131125,"firstChar":"","name":"安平县"},{"code":131126,"firstChar":"","name":"故城县"},{"code":131127,"firstChar":"","name":"景县"},{"code":131128,"firstChar":"","name":"阜城县"},{"code":131181,"firstChar":"","name":"冀州市"},{"code":131182,"firstChar":"","name":"深州市"}]},{"code":101090900,"firstChar":"x","name":"邢台","subLevelModelList":[{"code":130502,"firstChar":"","name":"桥东区"},{"code":130503,"firstChar":"","name":"桥西区"},{"code":130522,"firstChar":"","name":"临城县"},{"code":130523,"firstChar":"","name":"内丘县"},{"code":130524,"firstChar":"","name":"柏乡县"},{"code":130525,"firstChar":"","name":"隆尧县"},{"code":130526,"firstChar":"","name":"任县"},{"code":130527,"firstChar":"","name":"南和县"},{"code":130528,"firstChar":"","name":"宁晋县"},{"code":130529,"firstChar":"","name":"巨鹿县"},{"code":130530,"firstChar":"","name":"新河县"},{"code":130531,"firstChar":"","name":"广宗县"},{"code":130532,"firstChar":"","name":"平乡县"},{"code":130533,"firstChar":"","name":"威县"},{"code":130534,"firstChar":"","name":"清河县"},{"code":130535,"firstChar":"","name":"临西县"},{"code":130581,"firstChar":"","name":"南宫市"},{"code":130582,"firstChar":"","name":"沙河市"}]},{"code":101091000,"firstChar":"h","name":"邯郸","subLevelModelList":[{"code":130402,"firstChar":"","name":"邯山区"},{"code":130403,"firstChar":"","name":"丛台区"},{"code":130404,"firstChar":"","name":"复兴区"},{"code":130406,"firstChar":"","name":"峰峰矿区"},{"code":130423,"firstChar":"","name":"临漳县"},{"code":130424,"firstChar":"","name":"成安县"},{"code":130425,"firstChar":"","name":"大名县"},{"code":130426,"firstChar":"","name":"涉县"},{"code":130427,"firstChar":"","name":"磁县"},{"code":130428,"firstChar":"","name":"肥乡县"},{"code":130429,"firstChar":"","name":"永年县"},{"code":130430,"firstChar":"","name":"邱县"},{"code":130431,"firstChar":"","name":"鸡泽县"},{"code":130432,"firstChar":"","name":"广平县"},{"code":130433,"firstChar":"","name":"馆陶县"},{"code":130434,"firstChar":"","name":"魏县"},{"code":130435,"firstChar":"","name":"曲周县"},{"code":130481,"firstChar":"","name":"武安市"}]},{"code":101091100,"firstChar":"q","name":"秦皇岛","subLevelModelList":[{"code":130302,"firstChar":"","name":"海港区"},{"code":130303,"firstChar":"","name":"山海关区"},{"code":130304,"firstChar":"","name":"北戴河区"},{"code":130321,"firstChar":"","name":"青龙满族自治县"},{"code":130322,"firstChar":"","name":"昌黎县"},{"code":130306,"firstChar":"","name":"抚宁区"},{"code":130324,"firstChar":"","name":"卢龙县"}]}]},{"code":101100000,"firstChar":"s","name":"山西","subLevelModelList":[{"code":101100100,"firstChar":"t","name":"太原","subLevelModelList":[{"code":140105,"firstChar":"","name":"小店区"},{"code":140106,"firstChar":"","name":"迎泽区"},{"code":140107,"firstChar":"","name":"杏花岭区"},{"code":140108,"firstChar":"","name":"尖草坪区"},{"code":140109,"firstChar":"","name":"万柏林区"},{"code":140110,"firstChar":"","name":"晋源区"},{"code":140121,"firstChar":"","name":"清徐县"},{"code":140122,"firstChar":"","name":"阳曲县"},{"code":140123,"firstChar":"","name":"娄烦县"},{"code":140181,"firstChar":"","name":"古交市"}]},{"code":101100200,"firstChar":"d","name":"大同","subLevelModelList":[{"code":140202,"firstChar":"","name":"城区"},{"code":140203,"firstChar":"","name":"矿区"},{"code":140211,"firstChar":"","name":"南郊区"},{"code":140212,"firstChar":"","name":"新荣区"},{"code":140221,"firstChar":"","name":"阳高县"},{"code":140222,"firstChar":"","name":"天镇县"},{"code":140223,"firstChar":"","name":"广灵县"},{"code":140224,"firstChar":"","name":"灵丘县"},{"code":140225,"firstChar":"","name":"浑源县"},{"code":140226,"firstChar":"","name":"左云县"}]},{"code":101100300,"firstChar":"y","name":"阳泉","subLevelModelList":[{"code":140302,"firstChar":"","name":"城区"},{"code":140303,"firstChar":"","name":"矿区"},{"code":140311,"firstChar":"","name":"郊区"},{"code":140321,"firstChar":"","name":"平定县"},{"code":140322,"firstChar":"","name":"盂县"}]},{"code":101100400,"firstChar":"j","name":"晋中","subLevelModelList":[{"code":140702,"firstChar":"","name":"榆次区"},{"code":140721,"firstChar":"","name":"榆社县"},{"code":140722,"firstChar":"","name":"左权县"},{"code":140723,"firstChar":"","name":"和顺县"},{"code":140724,"firstChar":"","name":"昔阳县"},{"code":140725,"firstChar":"","name":"寿阳县"},{"code":140726,"firstChar":"","name":"太谷县"},{"code":140727,"firstChar":"","name":"祁县"},{"code":140728,"firstChar":"","name":"平遥县"},{"code":140729,"firstChar":"","name":"灵石县"},{"code":140781,"firstChar":"","name":"介休市"}]},{"code":101100500,"firstChar":"c","name":"长治","subLevelModelList":[{"code":140402,"firstChar":"","name":"城区"},{"code":140411,"firstChar":"","name":"郊区"},{"code":140423,"firstChar":"","name":"襄垣县"},{"code":140424,"firstChar":"","name":"屯留县"},{"code":140425,"firstChar":"","name":"平顺县"},{"code":140426,"firstChar":"","name":"黎城县"},{"code":140427,"firstChar":"","name":"壶关县"},{"code":140428,"firstChar":"","name":"长子县"},{"code":140429,"firstChar":"","name":"武乡县"},{"code":140430,"firstChar":"","name":"沁县"},{"code":140431,"firstChar":"","name":"沁源县"},{"code":140481,"firstChar":"","name":"潞城市"}]},{"code":101100600,"firstChar":"j","name":"晋城","subLevelModelList":[{"code":140502,"firstChar":"","name":"城区"},{"code":140521,"firstChar":"","name":"沁水县"},{"code":140522,"firstChar":"","name":"阳城县"},{"code":140524,"firstChar":"","name":"陵川县"},{"code":140525,"firstChar":"","name":"泽州县"},{"code":140581,"firstChar":"","name":"高平市"}]},{"code":101100700,"firstChar":"l","name":"临汾","subLevelModelList":[{"code":141002,"firstChar":"","name":"尧都区"},{"code":141021,"firstChar":"","name":"曲沃县"},{"code":141022,"firstChar":"","name":"翼城县"},{"code":141023,"firstChar":"","name":"襄汾县"},{"code":141024,"firstChar":"","name":"洪洞县"},{"code":141025,"firstChar":"","name":"古县"},{"code":141026,"firstChar":"","name":"安泽县"},{"code":141027,"firstChar":"","name":"浮山县"},{"code":141028,"firstChar":"","name":"吉县"},{"code":141029,"firstChar":"","name":"乡宁县"},{"code":141030,"firstChar":"","name":"大宁县"},{"code":141031,"firstChar":"","name":"隰县"},{"code":141032,"firstChar":"","name":"永和县"},{"code":141033,"firstChar":"","name":"蒲县"},{"code":141034,"firstChar":"","name":"汾西县"},{"code":141081,"firstChar":"","name":"侯马市"},{"code":141082,"firstChar":"","name":"霍州市"}]},{"code":101100800,"firstChar":"y","name":"运城","subLevelModelList":[{"code":140802,"firstChar":"","name":"盐湖区"},{"code":140821,"firstChar":"","name":"临猗县"},{"code":140822,"firstChar":"","name":"万荣县"},{"code":140823,"firstChar":"","name":"闻喜县"},{"code":140824,"firstChar":"","name":"稷山县"},{"code":140825,"firstChar":"","name":"新绛县"},{"code":140826,"firstChar":"","name":"绛县"},{"code":140827,"firstChar":"","name":"垣曲县"},{"code":140828,"firstChar":"","name":"夏县"},{"code":140829,"firstChar":"","name":"平陆县"},{"code":140830,"firstChar":"","name":"芮城县"},{"code":140881,"firstChar":"","name":"永济市"},{"code":140882,"firstChar":"","name":"河津市"}]},{"code":101100900,"firstChar":"s","name":"朔州","subLevelModelList":[{"code":140602,"firstChar":"","name":"朔城区"},{"code":140603,"firstChar":"","name":"平鲁区"},{"code":140621,"firstChar":"","name":"山阴县"},{"code":140622,"firstChar":"","name":"应县"},{"code":140623,"firstChar":"","name":"右玉县"},{"code":140624,"firstChar":"","name":"怀仁县"}]},{"code":101101000,"firstChar":"x","name":"忻州","subLevelModelList":[{"code":140902,"firstChar":"","name":"忻府区"},{"code":140921,"firstChar":"","name":"定襄县"},{"code":140922,"firstChar":"","name":"五台县"},{"code":140923,"firstChar":"","name":"代县"},{"code":140924,"firstChar":"","name":"繁峙县"},{"code":140925,"firstChar":"","name":"宁武县"},{"code":140926,"firstChar":"","name":"静乐县"},{"code":140927,"firstChar":"","name":"神池县"},{"code":140928,"firstChar":"","name":"五寨县"},{"code":140929,"firstChar":"","name":"岢岚县"},{"code":140930,"firstChar":"","name":"河曲县"},{"code":140931,"firstChar":"","name":"保德县"},{"code":140932,"firstChar":"","name":"偏关县"},{"code":140981,"firstChar":"","name":"原平市"}]},{"code":101101100,"firstChar":"l","name":"吕梁","subLevelModelList":[{"code":141102,"firstChar":"","name":"离石区"},{"code":141121,"firstChar":"","name":"文水县"},{"code":141122,"firstChar":"","name":"交城县"},{"code":141123,"firstChar":"","name":"兴县"},{"code":141124,"firstChar":"","name":"临县"},{"code":141125,"firstChar":"","name":"柳林县"},{"code":141126,"firstChar":"","name":"石楼县"},{"code":141127,"firstChar":"","name":"岚县"},{"code":141128,"firstChar":"","name":"方山县"},{"code":141129,"firstChar":"","name":"中阳县"},{"code":141130,"firstChar":"","name":"交口县"},{"code":141181,"firstChar":"","name":"孝义市"},{"code":141182,"firstChar":"","name":"汾阳市"}]}]},{"code":101110000,"firstChar":"a","name":"陕西","subLevelModelList":[{"code":101110100,"firstChar":"x","name":"西安","subLevelModelList":[{"code":610102,"firstChar":"","name":"新城区"},{"code":610103,"firstChar":"","name":"碑林区"},{"code":610104,"firstChar":"","name":"莲湖区"},{"code":610111,"firstChar":"","name":"灞桥区"},{"code":610112,"firstChar":"","name":"未央区"},{"code":610113,"firstChar":"","name":"雁塔区"},{"code":610114,"firstChar":"","name":"阎良区"},{"code":610115,"firstChar":"","name":"临潼区"},{"code":610116,"firstChar":"","name":"长安区"},{"code":610117,"firstChar":"","name":"高陵区"},{"code":610122,"firstChar":"","name":"蓝田县"},{"code":610124,"firstChar":"","name":"周至县"},{"code":610125,"firstChar":"","name":"户县"}]},{"code":101110200,"firstChar":"x","name":"咸阳","subLevelModelList":[{"code":610402,"firstChar":"","name":"秦都区"},{"code":610403,"firstChar":"","name":"杨陵区"},{"code":610404,"firstChar":"","name":"渭城区"},{"code":610422,"firstChar":"","name":"三原县"},{"code":610423,"firstChar":"","name":"泾阳县"},{"code":610424,"firstChar":"","name":"乾县"},{"code":610425,"firstChar":"","name":"礼泉县"},{"code":610426,"firstChar":"","name":"永寿县"},{"code":610427,"firstChar":"","name":"彬县"},{"code":610428,"firstChar":"","name":"长武县"},{"code":610429,"firstChar":"","name":"旬邑县"},{"code":610430,"firstChar":"","name":"淳化县"},{"code":610431,"firstChar":"","name":"武功县"},{"code":610481,"firstChar":"","name":"兴平市"}]},{"code":101110300,"firstChar":"y","name":"延安","subLevelModelList":[{"code":610602,"firstChar":"","name":"宝塔区"},{"code":610621,"firstChar":"","name":"延长县"},{"code":610622,"firstChar":"","name":"延川县"},{"code":610623,"firstChar":"","name":"子长县"},{"code":610624,"firstChar":"","name":"安塞县"},{"code":610625,"firstChar":"","name":"志丹县"},{"code":610626,"firstChar":"","name":"吴起县"},{"code":610627,"firstChar":"","name":"甘泉县"},{"code":610628,"firstChar":"","name":"富县"},{"code":610629,"firstChar":"","name":"洛川县"},{"code":610630,"firstChar":"","name":"宜川县"},{"code":610631,"firstChar":"","name":"黄龙县"},{"code":610632,"firstChar":"","name":"黄陵县"}]},{"code":101110400,"firstChar":"y","name":"榆林","subLevelModelList":[{"code":610802,"firstChar":"","name":"榆阳区"},{"code":610821,"firstChar":"","name":"神木县"},{"code":610822,"firstChar":"","name":"府谷县"},{"code":610803,"firstChar":"","name":"横山区"},{"code":610824,"firstChar":"","name":"靖边县"},{"code":610825,"firstChar":"","name":"定边县"},{"code":610826,"firstChar":"","name":"绥德县"},{"code":610827,"firstChar":"","name":"米脂县"},{"code":610828,"firstChar":"","name":"佳县"},{"code":610829,"firstChar":"","name":"吴堡县"},{"code":610830,"firstChar":"","name":"清涧县"},{"code":610831,"firstChar":"","name":"子洲县"}]},{"code":101110500,"firstChar":"w","name":"渭南","subLevelModelList":[{"code":610502,"firstChar":"","name":"临渭区"},{"code":610503,"firstChar":"","name":"华州区"},{"code":610522,"firstChar":"","name":"潼关县"},{"code":610523,"firstChar":"","name":"大荔县"},{"code":610524,"firstChar":"","name":"合阳县"},{"code":610525,"firstChar":"","name":"澄城县"},{"code":610526,"firstChar":"","name":"蒲城县"},{"code":610527,"firstChar":"","name":"白水县"},{"code":610528,"firstChar":"","name":"富平县"},{"code":610581,"firstChar":"","name":"韩城市"},{"code":610582,"firstChar":"","name":"华阴市"}]},{"code":101110600,"firstChar":"s","name":"商洛","subLevelModelList":[{"code":611002,"firstChar":"","name":"商州区"},{"code":611021,"firstChar":"","name":"洛南县"},{"code":611022,"firstChar":"","name":"丹凤县"},{"code":611023,"firstChar":"","name":"商南县"},{"code":611024,"firstChar":"","name":"山阳县"},{"code":611025,"firstChar":"","name":"镇安县"},{"code":611026,"firstChar":"","name":"柞水县"}]},{"code":101110700,"firstChar":"a","name":"安康","subLevelModelList":[{"code":610902,"firstChar":"","name":"汉滨区"},{"code":610921,"firstChar":"","name":"汉阴县"},{"code":610922,"firstChar":"","name":"石泉县"},{"code":610923,"firstChar":"","name":"宁陕县"},{"code":610924,"firstChar":"","name":"紫阳县"},{"code":610925,"firstChar":"","name":"岚皋县"},{"code":610926,"firstChar":"","name":"平利县"},{"code":610927,"firstChar":"","name":"镇坪县"},{"code":610928,"firstChar":"","name":"旬阳县"},{"code":610929,"firstChar":"","name":"白河县"}]},{"code":101110800,"firstChar":"h","name":"汉中","subLevelModelList":[{"code":610702,"firstChar":"","name":"汉台区"},{"code":610721,"firstChar":"","name":"南郑县"},{"code":610722,"firstChar":"","name":"城固县"},{"code":610723,"firstChar":"","name":"洋县"},{"code":610724,"firstChar":"","name":"西乡县"},{"code":610725,"firstChar":"","name":"勉县"},{"code":610726,"firstChar":"","name":"宁强县"},{"code":610727,"firstChar":"","name":"略阳县"},{"code":610728,"firstChar":"","name":"镇巴县"},{"code":610729,"firstChar":"","name":"留坝县"},{"code":610730,"firstChar":"","name":"佛坪县"}]},{"code":101110900,"firstChar":"b","name":"宝鸡","subLevelModelList":[{"code":610302,"firstChar":"","name":"渭滨区"},{"code":610303,"firstChar":"","name":"金台区"},{"code":610304,"firstChar":"","name":"陈仓区"},{"code":610322,"firstChar":"","name":"凤翔县"},{"code":610323,"firstChar":"","name":"岐山县"},{"code":610324,"firstChar":"","name":"扶风县"},{"code":610326,"firstChar":"","name":"眉县"},{"code":610327,"firstChar":"","name":"陇县"},{"code":610328,"firstChar":"","name":"千阳县"},{"code":610329,"firstChar":"","name":"麟游县"},{"code":610330,"firstChar":"","name":"凤县"},{"code":610331,"firstChar":"","name":"太白县"}]},{"code":101111000,"firstChar":"t","name":"铜川","subLevelModelList":[{"code":610202,"firstChar":"","name":"王益区"},{"code":610203,"firstChar":"","name":"印台区"},{"code":610204,"firstChar":"","name":"耀州区"},{"code":610222,"firstChar":"","name":"宜君县"}]}]},{"code":101120000,"firstChar":"s","name":"山东","subLevelModelList":[{"code":101120100,"firstChar":"j","name":"济南","subLevelModelList":[{"code":370102,"firstChar":"","name":"历下区"},{"code":370103,"firstChar":"","name":"市中区"},{"code":370104,"firstChar":"","name":"槐荫区"},{"code":370105,"firstChar":"","name":"天桥区"},{"code":370112,"firstChar":"","name":"历城区"},{"code":370113,"firstChar":"","name":"长清区"},{"code":370124,"firstChar":"","name":"平阴县"},{"code":370125,"firstChar":"","name":"济阳县"},{"code":370126,"firstChar":"","name":"商河县"},{"code":370181,"firstChar":"","name":"章丘市"}]},{"code":101120200,"firstChar":"q","name":"青岛","subLevelModelList":[{"code":370202,"firstChar":"","name":"市南区"},{"code":370203,"firstChar":"","name":"市北区"},{"code":370211,"firstChar":"","name":"黄岛区"},{"code":370212,"firstChar":"","name":"崂山区"},{"code":370213,"firstChar":"","name":"李沧区"},{"code":370214,"firstChar":"","name":"城阳区"},{"code":370281,"firstChar":"","name":"胶州市"},{"code":370282,"firstChar":"","name":"即墨市"},{"code":370283,"firstChar":"","name":"平度市"},{"code":370285,"firstChar":"","name":"莱西市"}]},{"code":101120300,"firstChar":"z","name":"淄博","subLevelModelList":[{"code":370302,"firstChar":"","name":"淄川区"},{"code":370303,"firstChar":"","name":"张店区"},{"code":370304,"firstChar":"","name":"博山区"},{"code":370305,"firstChar":"","name":"临淄区"},{"code":370306,"firstChar":"","name":"周村区"},{"code":370321,"firstChar":"","name":"桓台县"},{"code":370322,"firstChar":"","name":"高青县"},{"code":370323,"firstChar":"","name":"沂源县"}]},{"code":101120400,"firstChar":"d","name":"德州","subLevelModelList":[{"code":371402,"firstChar":"","name":"德城区"},{"code":371403,"firstChar":"","name":"陵城区"},{"code":371422,"firstChar":"","name":"宁津县"},{"code":371423,"firstChar":"","name":"庆云县"},{"code":371424,"firstChar":"","name":"临邑县"},{"code":371425,"firstChar":"","name":"齐河县"},{"code":371426,"firstChar":"","name":"平原县"},{"code":371427,"firstChar":"","name":"夏津县"},{"code":371428,"firstChar":"","name":"武城县"},{"code":371481,"firstChar":"","name":"乐陵市"},{"code":371482,"firstChar":"","name":"禹城市"}]},{"code":101120500,"firstChar":"y","name":"烟台","subLevelModelList":[{"code":370602,"firstChar":"","name":"芝罘区"},{"code":370611,"firstChar":"","name":"福山区"},{"code":370612,"firstChar":"","name":"牟平区"},{"code":370613,"firstChar":"","name":"莱山区"},{"code":370634,"firstChar":"","name":"长岛县"},{"code":370681,"firstChar":"","name":"龙口市"},{"code":370682,"firstChar":"","name":"莱阳市"},{"code":370683,"firstChar":"","name":"莱州市"},{"code":370684,"firstChar":"","name":"蓬莱市"},{"code":370685,"firstChar":"","name":"招远市"},{"code":370686,"firstChar":"","name":"栖霞市"},{"code":370687,"firstChar":"","name":"海阳市"}]},{"code":101120600,"firstChar":"w","name":"潍坊","subLevelModelList":[{"code":370702,"firstChar":"","name":"潍城区"},{"code":370703,"firstChar":"","name":"寒亭区"},{"code":370704,"firstChar":"","name":"坊子区"},{"code":370705,"firstChar":"","name":"奎文区"},{"code":370724,"firstChar":"","name":"临朐县"},{"code":370725,"firstChar":"","name":"昌乐县"},{"code":370781,"firstChar":"","name":"青州市"},{"code":370782,"firstChar":"","name":"诸城市"},{"code":370783,"firstChar":"","name":"寿光市"},{"code":370784,"firstChar":"","name":"安丘市"},{"code":370785,"firstChar":"","name":"高密市"},{"code":370786,"firstChar":"","name":"昌邑市"}]},{"code":101120700,"firstChar":"j","name":"济宁","subLevelModelList":[{"code":370811,"firstChar":"","name":"任城区"},{"code":370812,"firstChar":"","name":"兖州区"},{"code":370826,"firstChar":"","name":"微山县"},{"code":370827,"firstChar":"","name":"鱼台县"},{"code":370828,"firstChar":"","name":"金乡县"},{"code":370829,"firstChar":"","name":"嘉祥县"},{"code":370830,"firstChar":"","name":"汶上县"},{"code":370831,"firstChar":"","name":"泗水县"},{"code":370832,"firstChar":"","name":"梁山县"},{"code":370881,"firstChar":"","name":"曲阜市"},{"code":370883,"firstChar":"","name":"邹城市"}]},{"code":101120800,"firstChar":"t","name":"泰安","subLevelModelList":[{"code":370902,"firstChar":"","name":"泰山区"},{"code":370911,"firstChar":"","name":"岱岳区"},{"code":370921,"firstChar":"","name":"宁阳县"},{"code":370923,"firstChar":"","name":"东平县"},{"code":370982,"firstChar":"","name":"新泰市"},{"code":370983,"firstChar":"","name":"肥城市"}]},{"code":101120900,"firstChar":"l","name":"临沂","subLevelModelList":[{"code":371302,"firstChar":"","name":"兰山区"},{"code":371311,"firstChar":"","name":"罗庄区"},{"code":371312,"firstChar":"","name":"河东区"},{"code":371321,"firstChar":"","name":"沂南县"},{"code":371322,"firstChar":"","name":"郯城县"},{"code":371323,"firstChar":"","name":"沂水县"},{"code":371324,"firstChar":"","name":"兰陵县"},{"code":371325,"firstChar":"","name":"费县"},{"code":371326,"firstChar":"","name":"平邑县"},{"code":371327,"firstChar":"","name":"莒南县"},{"code":371328,"firstChar":"","name":"蒙阴县"},{"code":371329,"firstChar":"","name":"临沭县"}]},{"code":101121000,"firstChar":"h","name":"菏泽","subLevelModelList":[{"code":371702,"firstChar":"","name":"牡丹区"},{"code":371721,"firstChar":"","name":"曹县"},{"code":371722,"firstChar":"","name":"单县"},{"code":371723,"firstChar":"","name":"成武县"},{"code":371724,"firstChar":"","name":"巨野县"},{"code":371725,"firstChar":"","name":"郓城县"},{"code":371726,"firstChar":"","name":"鄄城县"},{"code":371727,"firstChar":"","name":"定陶区"},{"code":371728,"firstChar":"","name":"东明县"}]},{"code":101121100,"firstChar":"b","name":"滨州","subLevelModelList":[{"code":371602,"firstChar":"","name":"滨城区"},{"code":371603,"firstChar":"","name":"沾化区"},{"code":371621,"firstChar":"","name":"惠民县"},{"code":371622,"firstChar":"","name":"阳信县"},{"code":371623,"firstChar":"","name":"无棣县"},{"code":371625,"firstChar":"","name":"博兴县"},{"code":371626,"firstChar":"","name":"邹平县"}]},{"code":101121200,"firstChar":"d","name":"东营","subLevelModelList":[{"code":370503,"firstChar":"","name":"河口区"},{"code":370521,"firstChar":"","name":"垦利县"},{"code":370522,"firstChar":"","name":"利津县"},{"code":370523,"firstChar":"","name":"广饶县"}]},{"code":101121300,"firstChar":"w","name":"威海","subLevelModelList":[{"code":371002,"firstChar":"","name":"环翠区"},{"code":371003,"firstChar":"","name":"文登区"},{"code":371082,"firstChar":"","name":"荣成市"},{"code":371083,"firstChar":"","name":"乳山市"}]},{"code":101121400,"firstChar":"z","name":"枣庄","subLevelModelList":[{"code":370402,"firstChar":"","name":"市中区"},{"code":370403,"firstChar":"","name":"薛城区"},{"code":370404,"firstChar":"","name":"峄城区"},{"code":370405,"firstChar":"","name":"台儿庄区"},{"code":370406,"firstChar":"","name":"山亭区"},{"code":370481,"firstChar":"","name":"滕州市"}]},{"code":101121500,"firstChar":"r","name":"日照","subLevelModelList":[{"code":371102,"firstChar":"","name":"东港区"},{"code":371103,"firstChar":"","name":"岚山区"},{"code":371121,"firstChar":"","name":"五莲县"},{"code":371122,"firstChar":"","name":"莒县"}]},{"code":101121600,"firstChar":"l","name":"莱芜","subLevelModelList":[{"code":371202,"firstChar":"","name":"莱城区"},{"code":371203,"firstChar":"","name":"钢城区"}]},{"code":101121700,"firstChar":"l","name":"聊城","subLevelModelList":[{"code":371502,"firstChar":"","name":"东昌府区"},{"code":371521,"firstChar":"","name":"阳谷县"},{"code":371522,"firstChar":"","name":"莘县"},{"code":371523,"firstChar":"","name":"茌平县"},{"code":371524,"firstChar":"","name":"东阿县"},{"code":371525,"firstChar":"","name":"冠县"},{"code":371526,"firstChar":"","name":"高唐县"},{"code":371581,"firstChar":"","name":"临清市"}]}]},{"code":101130000,"firstChar":"x","name":"新疆","subLevelModelList":[{"code":101130100,"firstChar":"w","name":"乌鲁木齐","subLevelModelList":[{"code":650102,"firstChar":"","name":"天山区"},{"code":650103,"firstChar":"","name":"沙依巴克区"},{"code":650104,"firstChar":"","name":"新市区"},{"code":650105,"firstChar":"","name":"水磨沟区"},{"code":650106,"firstChar":"","name":"头屯河区"},{"code":650107,"firstChar":"","name":"达坂城区"},{"code":650109,"firstChar":"","name":"米东区"}]},{"code":101130200,"firstChar":"k","name":"克拉玛依","subLevelModelList":[{"code":650202,"firstChar":"","name":"独山子区"},{"code":650204,"firstChar":"","name":"白碱滩区"},{"code":650205,"firstChar":"","name":"乌尔禾区"}]},{"code":101130300,"firstChar":"c","name":"昌吉","subLevelModelList":[{"code":652302,"firstChar":"","name":"阜康市"},{"code":652323,"firstChar":"","name":"呼图壁县"},{"code":652324,"firstChar":"","name":"玛纳斯县"},{"code":652325,"firstChar":"","name":"奇台县"},{"code":652327,"firstChar":"","name":"吉木萨尔县"},{"code":652328,"firstChar":"","name":"木垒哈萨克自治县"}]},{"code":101130400,"firstChar":"b","name":"巴音郭楞","subLevelModelList":[{"code":652801,"firstChar":"","name":"库尔勒市"},{"code":652822,"firstChar":"","name":"轮台县"},{"code":652823,"firstChar":"","name":"尉犁县"},{"code":652824,"firstChar":"","name":"若羌县"},{"code":652825,"firstChar":"","name":"且末县"},{"code":652826,"firstChar":"","name":"焉耆回族自治县"},{"code":652827,"firstChar":"","name":"和静县"},{"code":652828,"firstChar":"","name":"和硕县"},{"code":652829,"firstChar":"","name":"博湖县"}]},{"code":101130500,"firstChar":"b","name":"博尔塔拉","subLevelModelList":[{"code":652701,"firstChar":"","name":"博乐市"},{"code":652702,"firstChar":"","name":"阿拉山口市"},{"code":652722,"firstChar":"","name":"精河县"},{"code":652723,"firstChar":"","name":"温泉县"}]},{"code":101130600,"firstChar":"y","name":"伊犁","subLevelModelList":[{"code":654002,"firstChar":"","name":"伊宁市"},{"code":654003,"firstChar":"","name":"奎屯市"},{"code":654004,"firstChar":"","name":"霍尔果斯市"},{"code":654021,"firstChar":"","name":"伊宁县"},{"code":654022,"firstChar":"","name":"察布查尔锡伯自治县"},{"code":654023,"firstChar":"","name":"霍城县"},{"code":654024,"firstChar":"","name":"巩留县"},{"code":654025,"firstChar":"","name":"新源县"},{"code":654026,"firstChar":"","name":"昭苏县"},{"code":654027,"firstChar":"","name":"特克斯县"},{"code":654028,"firstChar":"","name":"尼勒克县"}]},{"code":101130700,"firstChar":"k","name":"克孜勒苏柯尔克孜","subLevelModelList":[{"code":653001,"firstChar":"","name":"阿图什市"},{"code":653022,"firstChar":"","name":"阿克陶县"},{"code":653023,"firstChar":"","name":"阿合奇县"},{"code":653024,"firstChar":"","name":"乌恰县"}]}]},{"code":101150000,"firstChar":"q","name":"青海","subLevelModelList":[{"code":101150100,"firstChar":"x","name":"西宁","subLevelModelList":[{"code":630102,"firstChar":"","name":"城东区"},{"code":630103,"firstChar":"","name":"城中区"},{"code":630104,"firstChar":"","name":"城西区"},{"code":630105,"firstChar":"","name":"城北区"},{"code":630121,"firstChar":"","name":"大通回族土族自治县"},{"code":630122,"firstChar":"","name":"湟中县"},{"code":630123,"firstChar":"","name":"湟源县"}]},{"code":101150200,"firstChar":"h","name":"海东","subLevelModelList":[{"code":630202,"firstChar":"","name":"乐都区"},{"code":630203,"firstChar":"","name":"平安区"},{"code":630222,"firstChar":"","name":"民和回族土族自治县"},{"code":630223,"firstChar":"","name":"互助土族自治县"},{"code":630224,"firstChar":"","name":"化隆回族自治县"},{"code":630225,"firstChar":"","name":"循化撒拉族自治县"}]},{"code":101150300,"firstChar":"h","name":"海北","subLevelModelList":[{"code":632221,"firstChar":"","name":"门源回族自治县"},{"code":632222,"firstChar":"","name":"祁连县"},{"code":632223,"firstChar":"","name":"海晏县"},{"code":632224,"firstChar":"","name":"刚察县"}]},{"code":101150400,"firstChar":"h","name":"黄南","subLevelModelList":[{"code":632321,"firstChar":"","name":"同仁县"},{"code":632322,"firstChar":"","name":"尖扎县"},{"code":632323,"firstChar":"","name":"泽库县"},{"code":632324,"firstChar":"","name":"河南蒙古族自治县"}]},{"code":101150500,"firstChar":"h","name":"海南","subLevelModelList":[{"code":632521,"firstChar":"","name":"共和县"},{"code":632522,"firstChar":"","name":"同德县"},{"code":632523,"firstChar":"","name":"贵德县"},{"code":632524,"firstChar":"","name":"兴海县"},{"code":632525,"firstChar":"","name":"贵南县"}]},{"code":101150600,"firstChar":"g","name":"果洛","subLevelModelList":[{"code":632621,"firstChar":"","name":"玛沁县"},{"code":632622,"firstChar":"","name":"班玛县"},{"code":632623,"firstChar":"","name":"甘德县"},{"code":632624,"firstChar":"","name":"达日县"},{"code":632625,"firstChar":"","name":"久治县"},{"code":632626,"firstChar":"","name":"玛多县"}]},{"code":101150700,"firstChar":"y","name":"玉树","subLevelModelList":[{"code":632722,"firstChar":"","name":"杂多县"},{"code":632723,"firstChar":"","name":"称多县"},{"code":632724,"firstChar":"","name":"治多县"},{"code":632725,"firstChar":"","name":"囊谦县"},{"code":632726,"firstChar":"","name":"曲麻莱县"}]},{"code":101150800,"firstChar":"h","name":"海西","subLevelModelList":[{"code":632801,"firstChar":"","name":"格尔木市"},{"code":632802,"firstChar":"","name":"德令哈市"},{"code":632821,"firstChar":"","name":"乌兰县"},{"code":632822,"firstChar":"","name":"都兰县"},{"code":632823,"firstChar":"","name":"天峻县"}]}]},{"code":101160000,"firstChar":"g","name":"甘肃","subLevelModelList":[{"code":101160100,"firstChar":"l","name":"兰州","subLevelModelList":[{"code":620102,"firstChar":"","name":"城关区"},{"code":620103,"firstChar":"","name":"七里河区"},{"code":620104,"firstChar":"","name":"西固区"},{"code":620105,"firstChar":"","name":"安宁区"},{"code":620111,"firstChar":"","name":"红古区"},{"code":620121,"firstChar":"","name":"永登县"},{"code":620122,"firstChar":"","name":"皋兰县"},{"code":620123,"firstChar":"","name":"榆中县"}]},{"code":101160200,"firstChar":"d","name":"定西","subLevelModelList":[{"code":621102,"firstChar":"","name":"安定区"},{"code":621121,"firstChar":"","name":"通渭县"},{"code":621122,"firstChar":"","name":"陇西县"},{"code":621123,"firstChar":"","name":"渭源县"},{"code":621124,"firstChar":"","name":"临洮县"},{"code":621125,"firstChar":"","name":"漳县"},{"code":621126,"firstChar":"","name":"岷县"}]},{"code":101160300,"firstChar":"p","name":"平凉","subLevelModelList":[{"code":620802,"firstChar":"","name":"崆峒区"},{"code":620821,"firstChar":"","name":"泾川县"},{"code":620822,"firstChar":"","name":"灵台县"},{"code":620823,"firstChar":"","name":"崇信县"},{"code":620824,"firstChar":"","name":"华亭县"},{"code":620825,"firstChar":"","name":"庄浪县"},{"code":620826,"firstChar":"","name":"静宁县"}]},{"code":101160400,"firstChar":"q","name":"庆阳","subLevelModelList":[{"code":621002,"firstChar":"","name":"西峰区"},{"code":621021,"firstChar":"","name":"庆城县"},{"code":621022,"firstChar":"","name":"环县"},{"code":621023,"firstChar":"","name":"华池县"},{"code":621024,"firstChar":"","name":"合水县"},{"code":621025,"firstChar":"","name":"正宁县"},{"code":621026,"firstChar":"","name":"宁县"},{"code":621027,"firstChar":"","name":"镇原县"}]},{"code":101160500,"firstChar":"w","name":"武威","subLevelModelList":[{"code":620602,"firstChar":"","name":"凉州区"},{"code":620621,"firstChar":"","name":"民勤县"},{"code":620622,"firstChar":"","name":"古浪县"},{"code":620623,"firstChar":"","name":"天祝藏族自治县"}]},{"code":101160600,"firstChar":"j","name":"金昌","subLevelModelList":[{"code":620302,"firstChar":"","name":"金川区"},{"code":620321,"firstChar":"","name":"永昌县"}]},{"code":101160700,"firstChar":"z","name":"张掖","subLevelModelList":[{"code":620702,"firstChar":"","name":"甘州区"},{"code":620721,"firstChar":"","name":"肃南裕固族自治县"},{"code":620722,"firstChar":"","name":"民乐县"},{"code":620723,"firstChar":"","name":"临泽县"},{"code":620724,"firstChar":"","name":"高台县"},{"code":620725,"firstChar":"","name":"山丹县"}]},{"code":101160800,"firstChar":"j","name":"酒泉","subLevelModelList":[{"code":620902,"firstChar":"","name":"肃州区"},{"code":620921,"firstChar":"","name":"金塔县"},{"code":620922,"firstChar":"","name":"瓜州县"},{"code":620923,"firstChar":"","name":"肃北蒙古族自治县"},{"code":620924,"firstChar":"","name":"阿克塞哈萨克族自治县"},{"code":620981,"firstChar":"","name":"玉门市"},{"code":620982,"firstChar":"","name":"敦煌市"}]},{"code":101160900,"firstChar":"t","name":"天水","subLevelModelList":[{"code":620502,"firstChar":"","name":"秦州区"},{"code":620503,"firstChar":"","name":"麦积区"},{"code":620521,"firstChar":"","name":"清水县"},{"code":620522,"firstChar":"","name":"秦安县"},{"code":620523,"firstChar":"","name":"甘谷县"},{"code":620524,"firstChar":"","name":"武山县"},{"code":620525,"firstChar":"","name":"张家川回族自治县"}]},{"code":101161000,"firstChar":"b","name":"白银","subLevelModelList":[{"code":620403,"firstChar":"","name":"平川区"},{"code":620421,"firstChar":"","name":"靖远县"},{"code":620422,"firstChar":"","name":"会宁县"},{"code":620423,"firstChar":"","name":"景泰县"}]},{"code":101161100,"firstChar":"l","name":"陇南","subLevelModelList":[{"code":621202,"firstChar":"","name":"武都区"},{"code":621221,"firstChar":"","name":"成县"},{"code":621222,"firstChar":"","name":"文县"},{"code":621223,"firstChar":"","name":"宕昌县"},{"code":621224,"firstChar":"","name":"康县"},{"code":621225,"firstChar":"","name":"西和县"},{"code":621226,"firstChar":"","name":"礼县"},{"code":621227,"firstChar":"","name":"徽县"},{"code":621228,"firstChar":"","name":"两当县"}]},{"code":101161200,"firstChar":"j","name":"嘉峪关"},{"code":101161300,"firstChar":"l","name":"临夏","subLevelModelList":[{"code":622922,"firstChar":"","name":"康乐县"},{"code":622923,"firstChar":"","name":"永靖县"},{"code":622924,"firstChar":"","name":"广河县"},{"code":622925,"firstChar":"","name":"和政县"},{"code":622926,"firstChar":"","name":"东乡族自治县"},{"code":622927,"firstChar":"","name":"积石山保安族东乡族撒拉族自治县"}]},{"code":101161400,"firstChar":"g","name":"甘南","subLevelModelList":[{"code":623001,"firstChar":"","name":"合作市"},{"code":623021,"firstChar":"","name":"临潭县"},{"code":623022,"firstChar":"","name":"卓尼县"},{"code":623023,"firstChar":"","name":"舟曲县"},{"code":623024,"firstChar":"","name":"迭部县"},{"code":623025,"firstChar":"","name":"玛曲县"},{"code":623026,"firstChar":"","name":"碌曲县"},{"code":623027,"firstChar":"","name":"夏河县"}]}]},{"code":101170000,"firstChar":"n","name":"宁夏","subLevelModelList":[{"code":101170100,"firstChar":"y","name":"银川","subLevelModelList":[{"code":640104,"firstChar":"","name":"兴庆区"},{"code":640105,"firstChar":"","name":"西夏区"},{"code":640106,"firstChar":"","name":"金凤区"},{"code":640121,"firstChar":"","name":"永宁县"},{"code":640122,"firstChar":"","name":"贺兰县"},{"code":640181,"firstChar":"","name":"灵武市"}]},{"code":101170200,"firstChar":"s","name":"石嘴山","subLevelModelList":[{"code":640202,"firstChar":"","name":"大武口区"},{"code":640205,"firstChar":"","name":"惠农区"},{"code":640221,"firstChar":"","name":"平罗县"}]},{"code":101170300,"firstChar":"w","name":"吴忠","subLevelModelList":[{"code":640302,"firstChar":"","name":"利通区"},{"code":640303,"firstChar":"","name":"红寺堡区"},{"code":640323,"firstChar":"","name":"盐池县"},{"code":640324,"firstChar":"","name":"同心县"},{"code":640381,"firstChar":"","name":"青铜峡市"}]},{"code":101170400,"firstChar":"g","name":"固原","subLevelModelList":[{"code":640402,"firstChar":"","name":"原州区"},{"code":640422,"firstChar":"","name":"西吉县"},{"code":640423,"firstChar":"","name":"隆德县"},{"code":640424,"firstChar":"","name":"泾源县"},{"code":640425,"firstChar":"","name":"彭阳县"}]},{"code":101170500,"firstChar":"z","name":"中卫","subLevelModelList":[{"code":640502,"firstChar":"","name":"沙坡头区"},{"code":640521,"firstChar":"","name":"中宁县"},{"code":640522,"firstChar":"","name":"海原县"}]}]},{"code":101180000,"firstChar":"h","name":"河南","subLevelModelList":[{"code":101180100,"firstChar":"z","name":"郑州","subLevelModelList":[{"code":410102,"firstChar":"","name":"中原区"},{"code":410103,"firstChar":"","name":"二七区"},{"code":410104,"firstChar":"","name":"管城回族区"},{"code":410105,"firstChar":"","name":"金水区"},{"code":410106,"firstChar":"","name":"上街区"},{"code":410108,"firstChar":"","name":"惠济区"},{"code":410122,"firstChar":"","name":"中牟县"},{"code":410181,"firstChar":"","name":"巩义市"},{"code":410182,"firstChar":"","name":"荥阳市"},{"code":410183,"firstChar":"","name":"新密市"},{"code":410184,"firstChar":"","name":"新郑市"},{"code":410185,"firstChar":"","name":"登封市"}]},{"code":101180200,"firstChar":"a","name":"安阳","subLevelModelList":[{"code":410502,"firstChar":"","name":"文峰区"},{"code":410503,"firstChar":"","name":"北关区"},{"code":410505,"firstChar":"","name":"殷都区"},{"code":410506,"firstChar":"","name":"龙安区"},{"code":410523,"firstChar":"","name":"汤阴县"},{"code":410526,"firstChar":"","name":"滑县"},{"code":410527,"firstChar":"","name":"内黄县"},{"code":410581,"firstChar":"","name":"林州市"}]},{"code":101180300,"firstChar":"x","name":"新乡","subLevelModelList":[{"code":410702,"firstChar":"","name":"红旗区"},{"code":410703,"firstChar":"","name":"卫滨区"},{"code":410704,"firstChar":"","name":"凤泉区"},{"code":410711,"firstChar":"","name":"牧野区"},{"code":410724,"firstChar":"","name":"获嘉县"},{"code":410725,"firstChar":"","name":"原阳县"},{"code":410726,"firstChar":"","name":"延津县"},{"code":410727,"firstChar":"","name":"封丘县"},{"code":410728,"firstChar":"","name":"长垣县"},{"code":410781,"firstChar":"","name":"卫辉市"},{"code":410782,"firstChar":"","name":"辉县市"}]},{"code":101180400,"firstChar":"x","name":"许昌","subLevelModelList":[{"code":411002,"firstChar":"","name":"魏都区"},{"code":411024,"firstChar":"","name":"鄢陵县"},{"code":411025,"firstChar":"","name":"襄城县"},{"code":411081,"firstChar":"","name":"禹州市"},{"code":411082,"firstChar":"","name":"长葛市"}]},{"code":101180500,"firstChar":"p","name":"平顶山","subLevelModelList":[{"code":410402,"firstChar":"","name":"新华区"},{"code":410403,"firstChar":"","name":"卫东区"},{"code":410404,"firstChar":"","name":"石龙区"},{"code":410411,"firstChar":"","name":"湛河区"},{"code":410421,"firstChar":"","name":"宝丰县"},{"code":410422,"firstChar":"","name":"叶县"},{"code":410423,"firstChar":"","name":"鲁山县"},{"code":410425,"firstChar":"","name":"郏县"},{"code":410481,"firstChar":"","name":"舞钢市"},{"code":410482,"firstChar":"","name":"汝州市"}]},{"code":101180600,"firstChar":"x","name":"信阳","subLevelModelList":[{"code":411502,"firstChar":"","name":"浉河区"},{"code":411503,"firstChar":"","name":"平桥区"},{"code":411521,"firstChar":"","name":"罗山县"},{"code":411522,"firstChar":"","name":"光山县"},{"code":411523,"firstChar":"","name":"新县"},{"code":411524,"firstChar":"","name":"商城县"},{"code":411525,"firstChar":"","name":"固始县"},{"code":411526,"firstChar":"","name":"潢川县"},{"code":411527,"firstChar":"","name":"淮滨县"},{"code":411528,"firstChar":"","name":"息县"}]},{"code":101180700,"firstChar":"n","name":"南阳","subLevelModelList":[{"code":411302,"firstChar":"","name":"宛城区"},{"code":411303,"firstChar":"","name":"卧龙区"},{"code":411321,"firstChar":"","name":"南召县"},{"code":411322,"firstChar":"","name":"方城县"},{"code":411323,"firstChar":"","name":"西峡县"},{"code":411324,"firstChar":"","name":"镇平县"},{"code":411325,"firstChar":"","name":"内乡县"},{"code":411326,"firstChar":"","name":"淅川县"},{"code":411327,"firstChar":"","name":"社旗县"},{"code":411328,"firstChar":"","name":"唐河县"},{"code":411329,"firstChar":"","name":"新野县"},{"code":411330,"firstChar":"","name":"桐柏县"},{"code":411381,"firstChar":"","name":"邓州市"}]},{"code":101180800,"firstChar":"k","name":"开封","subLevelModelList":[{"code":410202,"firstChar":"","name":"龙亭区"},{"code":410203,"firstChar":"","name":"顺河回族区"},{"code":410204,"firstChar":"","name":"鼓楼区"},{"code":410205,"firstChar":"","name":"禹王台区"},{"code":410212,"firstChar":"","name":"祥符区"},{"code":410221,"firstChar":"","name":"杞县"},{"code":410222,"firstChar":"","name":"通许县"},{"code":410223,"firstChar":"","name":"尉氏县"},{"code":410225,"firstChar":"","name":"兰考县"}]},{"code":101180900,"firstChar":"l","name":"洛阳","subLevelModelList":[{"code":410302,"firstChar":"","name":"老城区"},{"code":410303,"firstChar":"","name":"西工区"},{"code":410304,"firstChar":"","name":"瀍河回族区"},{"code":410305,"firstChar":"","name":"涧西区"},{"code":410306,"firstChar":"","name":"吉利区"},{"code":410311,"firstChar":"","name":"洛龙区"},{"code":410322,"firstChar":"","name":"孟津县"},{"code":410323,"firstChar":"","name":"新安县"},{"code":410324,"firstChar":"","name":"栾川县"},{"code":410325,"firstChar":"","name":"嵩县"},{"code":410326,"firstChar":"","name":"汝阳县"},{"code":410327,"firstChar":"","name":"宜阳县"},{"code":410328,"firstChar":"","name":"洛宁县"},{"code":410329,"firstChar":"","name":"伊川县"},{"code":410381,"firstChar":"","name":"偃师市"}]},{"code":101181000,"firstChar":"s","name":"商丘","subLevelModelList":[{"code":411402,"firstChar":"","name":"梁园区"},{"code":411403,"firstChar":"","name":"睢阳区"},{"code":411421,"firstChar":"","name":"民权县"},{"code":411422,"firstChar":"","name":"睢县"},{"code":411423,"firstChar":"","name":"宁陵县"},{"code":411424,"firstChar":"","name":"柘城县"},{"code":411425,"firstChar":"","name":"虞城县"},{"code":411426,"firstChar":"","name":"夏邑县"},{"code":411481,"firstChar":"","name":"永城市"}]},{"code":101181100,"firstChar":"j","name":"焦作","subLevelModelList":[{"code":410802,"firstChar":"","name":"解放区"},{"code":410803,"firstChar":"","name":"中站区"},{"code":410804,"firstChar":"","name":"马村区"},{"code":410811,"firstChar":"","name":"山阳区"},{"code":410821,"firstChar":"","name":"修武县"},{"code":410822,"firstChar":"","name":"博爱县"},{"code":410823,"firstChar":"","name":"武陟县"},{"code":410825,"firstChar":"","name":"温县"},{"code":410882,"firstChar":"","name":"沁阳市"},{"code":410883,"firstChar":"","name":"孟州市"}]},{"code":101181200,"firstChar":"h","name":"鹤壁","subLevelModelList":[{"code":410602,"firstChar":"","name":"鹤山区"},{"code":410603,"firstChar":"","name":"山城区"},{"code":410611,"firstChar":"","name":"淇滨区"},{"code":410621,"firstChar":"","name":"浚县"},{"code":410622,"firstChar":"","name":"淇县"}]},{"code":101181300,"firstChar":"p","name":"濮阳","subLevelModelList":[{"code":410902,"firstChar":"","name":"华龙区"},{"code":410922,"firstChar":"","name":"清丰县"},{"code":410923,"firstChar":"","name":"南乐县"},{"code":410926,"firstChar":"","name":"范县"},{"code":410927,"firstChar":"","name":"台前县"}]},{"code":101181400,"firstChar":"z","name":"周口","subLevelModelList":[{"code":411602,"firstChar":"","name":"川汇区"},{"code":411621,"firstChar":"","name":"扶沟县"},{"code":411622,"firstChar":"","name":"西华县"},{"code":411623,"firstChar":"","name":"商水县"},{"code":411624,"firstChar":"","name":"沈丘县"},{"code":411625,"firstChar":"","name":"郸城县"},{"code":411626,"firstChar":"","name":"淮阳县"},{"code":411627,"firstChar":"","name":"太康县"},{"code":411628,"firstChar":"","name":"鹿邑县"},{"code":411681,"firstChar":"","name":"项城市"}]},{"code":101181500,"firstChar":"l","name":"漯河","subLevelModelList":[{"code":411102,"firstChar":"","name":"源汇区"},{"code":411103,"firstChar":"","name":"郾城区"},{"code":411104,"firstChar":"","name":"召陵区"},{"code":411121,"firstChar":"","name":"舞阳县"},{"code":411122,"firstChar":"","name":"临颍县"}]},{"code":101181600,"firstChar":"z","name":"驻马店","subLevelModelList":[{"code":411702,"firstChar":"","name":"驿城区"},{"code":411721,"firstChar":"","name":"西平县"},{"code":411722,"firstChar":"","name":"上蔡县"},{"code":411723,"firstChar":"","name":"平舆县"},{"code":411724,"firstChar":"","name":"正阳县"},{"code":411725,"firstChar":"","name":"确山县"},{"code":411726,"firstChar":"","name":"泌阳县"},{"code":411727,"firstChar":"","name":"汝南县"},{"code":411728,"firstChar":"","name":"遂平县"},{"code":411729,"firstChar":"","name":"新蔡县"}]},{"code":101181700,"firstChar":"s","name":"三门峡","subLevelModelList":[{"code":411202,"firstChar":"","name":"湖滨区"},{"code":411203,"firstChar":"","name":"陕州区"},{"code":411221,"firstChar":"","name":"渑池县"},{"code":411224,"firstChar":"","name":"卢氏县"},{"code":411281,"firstChar":"","name":"义马市"},{"code":411282,"firstChar":"","name":"灵宝市"}]}]},{"code":101190000,"firstChar":"j","name":"江苏","subLevelModelList":[{"code":101190100,"firstChar":"n","name":"南京","subLevelModelList":[{"code":320102,"firstChar":"","name":"玄武区"},{"code":320104,"firstChar":"","name":"秦淮区"},{"code":320105,"firstChar":"","name":"建邺区"},{"code":320106,"firstChar":"","name":"鼓楼区"},{"code":320111,"firstChar":"","name":"浦口区"},{"code":320113,"firstChar":"","name":"栖霞区"},{"code":320114,"firstChar":"","name":"雨花台区"},{"code":320115,"firstChar":"","name":"江宁区"},{"code":320116,"firstChar":"","name":"六合区"},{"code":320117,"firstChar":"","name":"溧水区"},{"code":320118,"firstChar":"","name":"高淳区"}]},{"code":101190200,"firstChar":"w","name":"无锡","subLevelModelList":[{"code":320213,"firstChar":"","name":"梁溪区"},{"code":320214,"firstChar":"","name":"新吴区"},{"code":320205,"firstChar":"","name":"锡山区"},{"code":320206,"firstChar":"","name":"惠山区"},{"code":320211,"firstChar":"","name":"滨湖区"},{"code":320281,"firstChar":"","name":"江阴市"},{"code":320282,"firstChar":"","name":"宜兴市"}]},{"code":101190300,"firstChar":"z","name":"镇江","subLevelModelList":[{"code":321102,"firstChar":"","name":"京口区"},{"code":321111,"firstChar":"","name":"润州区"},{"code":321112,"firstChar":"","name":"丹徒区"},{"code":321181,"firstChar":"","name":"丹阳市"},{"code":321182,"firstChar":"","name":"扬中市"},{"code":321183,"firstChar":"","name":"句容市"}]},{"code":101190400,"firstChar":"s","name":"苏州","subLevelModelList":[{"code":320505,"firstChar":"","name":"虎丘区"},{"code":320506,"firstChar":"","name":"吴中区"},{"code":320507,"firstChar":"","name":"相城区"},{"code":320508,"firstChar":"","name":"姑苏区"},{"code":320509,"firstChar":"","name":"吴江区"},{"code":320581,"firstChar":"","name":"常熟市"},{"code":320582,"firstChar":"","name":"张家港市"},{"code":320585,"firstChar":"","name":"太仓市"}]},{"code":101190500,"firstChar":"n","name":"南通","subLevelModelList":[{"code":320602,"firstChar":"","name":"崇川区"},{"code":320611,"firstChar":"","name":"港闸区"},{"code":320612,"firstChar":"","name":"通州区"},{"code":320621,"firstChar":"","name":"海安县"},{"code":320623,"firstChar":"","name":"如东县"},{"code":320681,"firstChar":"","name":"启东市"},{"code":320682,"firstChar":"","name":"如皋市"},{"code":320684,"firstChar":"","name":"海门市"}]},{"code":101190600,"firstChar":"y","name":"扬州","subLevelModelList":[{"code":321002,"firstChar":"","name":"广陵区"},{"code":321003,"firstChar":"","name":"邗江区"},{"code":321012,"firstChar":"","name":"江都区"},{"code":321023,"firstChar":"","name":"宝应县"},{"code":321081,"firstChar":"","name":"仪征市"},{"code":321084,"firstChar":"","name":"高邮市"}]},{"code":101190700,"firstChar":"y","name":"盐城","subLevelModelList":[{"code":320902,"firstChar":"","name":"亭湖区"},{"code":320903,"firstChar":"","name":"盐都区"},{"code":320921,"firstChar":"","name":"响水县"},{"code":320922,"firstChar":"","name":"滨海县"},{"code":320923,"firstChar":"","name":"阜宁县"},{"code":320924,"firstChar":"","name":"射阳县"},{"code":320925,"firstChar":"","name":"建湖县"},{"code":320981,"firstChar":"","name":"东台市"},{"code":320904,"firstChar":"","name":"大丰区"}]},{"code":101190800,"firstChar":"x","name":"徐州","subLevelModelList":[{"code":320302,"firstChar":"","name":"鼓楼区"},{"code":320303,"firstChar":"","name":"云龙区"},{"code":320305,"firstChar":"","name":"贾汪区"},{"code":320311,"firstChar":"","name":"泉山区"},{"code":320312,"firstChar":"","name":"铜山区"},{"code":320321,"firstChar":"","name":"丰县"},{"code":320322,"firstChar":"","name":"沛县"},{"code":320324,"firstChar":"","name":"睢宁县"},{"code":320382,"firstChar":"","name":"邳州市"}]},{"code":101190900,"firstChar":"h","name":"淮安","subLevelModelList":[{"code":320802,"firstChar":"","name":"清河区"},{"code":320804,"firstChar":"","name":"淮阴区"},{"code":320811,"firstChar":"","name":"清浦区"},{"code":320826,"firstChar":"","name":"涟水县"},{"code":320829,"firstChar":"","name":"洪泽县"},{"code":320830,"firstChar":"","name":"盱眙县"},{"code":320831,"firstChar":"","name":"金湖县"}]},{"code":101191000,"firstChar":"l","name":"连云港","subLevelModelList":[{"code":320703,"firstChar":"","name":"连云区"},{"code":320706,"firstChar":"","name":"海州区"},{"code":320707,"firstChar":"","name":"赣榆区"},{"code":320722,"firstChar":"","name":"东海县"},{"code":320723,"firstChar":"","name":"灌云县"},{"code":320724,"firstChar":"","name":"灌南县"}]},{"code":101191100,"firstChar":"c","name":"常州","subLevelModelList":[{"code":320402,"firstChar":"","name":"天宁区"},{"code":320404,"firstChar":"","name":"钟楼区"},{"code":320411,"firstChar":"","name":"新北区"},{"code":320412,"firstChar":"","name":"武进区"},{"code":320481,"firstChar":"","name":"溧阳市"},{"code":320413,"firstChar":"","name":"金坛区"}]},{"code":101191200,"firstChar":"t","name":"泰州","subLevelModelList":[{"code":321202,"firstChar":"","name":"海陵区"},{"code":321203,"firstChar":"","name":"高港区"},{"code":321204,"firstChar":"","name":"姜堰区"},{"code":321281,"firstChar":"","name":"兴化市"},{"code":321282,"firstChar":"","name":"靖江市"},{"code":321283,"firstChar":"","name":"泰兴市"}]},{"code":101191300,"firstChar":"s","name":"宿迁","subLevelModelList":[{"code":321302,"firstChar":"","name":"宿城区"},{"code":321311,"firstChar":"","name":"宿豫区"},{"code":321322,"firstChar":"","name":"沭阳县"},{"code":321323,"firstChar":"","name":"泗阳县"},{"code":321324,"firstChar":"","name":"泗洪县"}]},{"code":101191400,"firstChar":"k","name":"昆山"},{"code":101191500,"firstChar":"x","name":"新沂"}]},{"code":101200000,"firstChar":"h","name":"湖北","subLevelModelList":[{"code":101200100,"firstChar":"w","name":"武汉","subLevelModelList":[{"code":420102,"firstChar":"","name":"江岸区"},{"code":420103,"firstChar":"","name":"江汉区"},{"code":420104,"firstChar":"","name":"硚口区"},{"code":420105,"firstChar":"","name":"汉阳区"},{"code":420106,"firstChar":"","name":"武昌区"},{"code":420107,"firstChar":"","name":"青山区"},{"code":420111,"firstChar":"","name":"洪山区"},{"code":420112,"firstChar":"","name":"东西湖区"},{"code":420113,"firstChar":"","name":"汉南区"},{"code":420114,"firstChar":"","name":"蔡甸区"},{"code":420115,"firstChar":"","name":"江夏区"},{"code":420116,"firstChar":"","name":"黄陂区"},{"code":420117,"firstChar":"","name":"新洲区"}]},{"code":101200200,"firstChar":"x","name":"襄阳","subLevelModelList":[{"code":420602,"firstChar":"","name":"襄城区"},{"code":420606,"firstChar":"","name":"樊城区"},{"code":420607,"firstChar":"","name":"襄州区"},{"code":420624,"firstChar":"","name":"南漳县"},{"code":420625,"firstChar":"","name":"谷城县"},{"code":420626,"firstChar":"","name":"保康县"},{"code":420682,"firstChar":"","name":"老河口市"},{"code":420683,"firstChar":"","name":"枣阳市"},{"code":420684,"firstChar":"","name":"宜城市"}]},{"code":101200300,"firstChar":"e","name":"鄂州","subLevelModelList":[{"code":420702,"firstChar":"","name":"梁子湖区"},{"code":420703,"firstChar":"","name":"华容区"},{"code":420704,"firstChar":"","name":"鄂城区"}]},{"code":101200400,"firstChar":"x","name":"孝感","subLevelModelList":[{"code":420902,"firstChar":"","name":"孝南区"},{"code":420921,"firstChar":"","name":"孝昌县"},{"code":420922,"firstChar":"","name":"大悟县"},{"code":420923,"firstChar":"","name":"云梦县"},{"code":420981,"firstChar":"","name":"应城市"},{"code":420982,"firstChar":"","name":"安陆市"},{"code":420984,"firstChar":"","name":"汉川市"}]},{"code":101200500,"firstChar":"h","name":"黄冈","subLevelModelList":[{"code":421102,"firstChar":"","name":"黄州区"},{"code":421121,"firstChar":"","name":"团风县"},{"code":421122,"firstChar":"","name":"红安县"},{"code":421123,"firstChar":"","name":"罗田县"},{"code":421124,"firstChar":"","name":"英山县"},{"code":421125,"firstChar":"","name":"浠水县"},{"code":421126,"firstChar":"","name":"蕲春县"},{"code":421127,"firstChar":"","name":"黄梅县"},{"code":421181,"firstChar":"","name":"麻城市"},{"code":421182,"firstChar":"","name":"武穴市"}]},{"code":101200600,"firstChar":"h","name":"黄石","subLevelModelList":[{"code":420203,"firstChar":"","name":"西塞山区"},{"code":420204,"firstChar":"","name":"下陆区"},{"code":420205,"firstChar":"","name":"铁山区"},{"code":420222,"firstChar":"","name":"阳新县"},{"code":420281,"firstChar":"","name":"大冶市"}]},{"code":101200700,"firstChar":"x","name":"咸宁","subLevelModelList":[{"code":421202,"firstChar":"","name":"咸安区"},{"code":421221,"firstChar":"","name":"嘉鱼县"},{"code":421222,"firstChar":"","name":"通城县"},{"code":421223,"firstChar":"","name":"崇阳县"},{"code":421224,"firstChar":"","name":"通山县"},{"code":421281,"firstChar":"","name":"赤壁市"}]},{"code":101200800,"firstChar":"j","name":"荆州","subLevelModelList":[{"code":421002,"firstChar":"","name":"沙市区"},{"code":421022,"firstChar":"","name":"公安县"},{"code":421023,"firstChar":"","name":"监利县"},{"code":421024,"firstChar":"","name":"江陵县"},{"code":421081,"firstChar":"","name":"石首市"},{"code":421083,"firstChar":"","name":"洪湖市"},{"code":421087,"firstChar":"","name":"松滋市"}]},{"code":101200900,"firstChar":"y","name":"宜昌","subLevelModelList":[{"code":420502,"firstChar":"","name":"西陵区"},{"code":420503,"firstChar":"","name":"伍家岗区"},{"code":420504,"firstChar":"","name":"点军区"},{"code":420505,"firstChar":"","name":"猇亭区"},{"code":420506,"firstChar":"","name":"夷陵区"},{"code":420525,"firstChar":"","name":"远安县"},{"code":420526,"firstChar":"","name":"兴山县"},{"code":420527,"firstChar":"","name":"秭归县"},{"code":420528,"firstChar":"","name":"长阳土家族自治县"},{"code":420529,"firstChar":"","name":"五峰土家族自治县"},{"code":420581,"firstChar":"","name":"宜都市"},{"code":420582,"firstChar":"","name":"当阳市"},{"code":420583,"firstChar":"","name":"枝江市"}]},{"code":101201000,"firstChar":"s","name":"十堰","subLevelModelList":[{"code":420302,"firstChar":"","name":"茅箭区"},{"code":420303,"firstChar":"","name":"张湾区"},{"code":420304,"firstChar":"","name":"郧阳区"},{"code":420322,"firstChar":"","name":"郧西县"},{"code":420323,"firstChar":"","name":"竹山县"},{"code":420324,"firstChar":"","name":"竹溪县"},{"code":420325,"firstChar":"","name":"房县"},{"code":420381,"firstChar":"","name":"丹江口市"}]},{"code":101201100,"firstChar":"s","name":"随州","subLevelModelList":[{"code":421303,"firstChar":"","name":"曾都区"},{"code":421321,"firstChar":"","name":"随县"},{"code":421381,"firstChar":"","name":"广水市"}]},{"code":101201200,"firstChar":"j","name":"荆门","subLevelModelList":[{"code":420802,"firstChar":"","name":"东宝区"},{"code":420804,"firstChar":"","name":"掇刀区"},{"code":420821,"firstChar":"","name":"京山县"},{"code":420822,"firstChar":"","name":"沙洋县"},{"code":420881,"firstChar":"","name":"钟祥市"}]},{"code":101201300,"firstChar":"e","name":"恩施","subLevelModelList":[{"code":422802,"firstChar":"","name":"利川市"},{"code":422822,"firstChar":"","name":"建始县"},{"code":422823,"firstChar":"","name":"巴东县"},{"code":422825,"firstChar":"","name":"宣恩县"},{"code":422826,"firstChar":"","name":"咸丰县"},{"code":422827,"firstChar":"","name":"来凤县"},{"code":422828,"firstChar":"","name":"鹤峰县"}]},{"code":101201400,"firstChar":"x","name":"仙桃"},{"code":101201500,"firstChar":"q","name":"潜江"}]},{"code":101210000,"firstChar":"z","name":"浙江","subLevelModelList":[{"code":101210100,"firstChar":"h","name":"杭州","subLevelModelList":[{"code":330102,"firstChar":"","name":"上城区"},{"code":330103,"firstChar":"","name":"下城区"},{"code":330104,"firstChar":"","name":"江干区"},{"code":330105,"firstChar":"","name":"拱墅区"},{"code":330106,"firstChar":"","name":"西湖区"},{"code":330108,"firstChar":"","name":"滨江区"},{"code":330109,"firstChar":"","name":"萧山区"},{"code":330110,"firstChar":"","name":"余杭区"},{"code":330111,"firstChar":"","name":"富阳区"},{"code":330122,"firstChar":"","name":"桐庐县"},{"code":330127,"firstChar":"","name":"淳安县"},{"code":330182,"firstChar":"","name":"建德市"},{"code":330185,"firstChar":"","name":"临安市"}]},{"code":101210200,"firstChar":"h","name":"湖州","subLevelModelList":[{"code":330502,"firstChar":"","name":"吴兴区"},{"code":330503,"firstChar":"","name":"南浔区"},{"code":330521,"firstChar":"","name":"德清县"},{"code":330522,"firstChar":"","name":"长兴县"},{"code":330523,"firstChar":"","name":"安吉县"}]},{"code":101210300,"firstChar":"j","name":"嘉兴","subLevelModelList":[{"code":330402,"firstChar":"","name":"南湖区"},{"code":330411,"firstChar":"","name":"秀洲区"},{"code":330421,"firstChar":"","name":"嘉善县"},{"code":330424,"firstChar":"","name":"海盐县"},{"code":330481,"firstChar":"","name":"海宁市"},{"code":330482,"firstChar":"","name":"平湖市"},{"code":330483,"firstChar":"","name":"桐乡市"}]},{"code":101210400,"firstChar":"n","name":"宁波","subLevelModelList":[{"code":330203,"firstChar":"","name":"海曙区"},{"code":330204,"firstChar":"","name":"江东区"},{"code":330205,"firstChar":"","name":"江北区"},{"code":330206,"firstChar":"","name":"北仑区"},{"code":330211,"firstChar":"","name":"镇海区"},{"code":330212,"firstChar":"","name":"鄞州区"},{"code":330225,"firstChar":"","name":"象山县"},{"code":330226,"firstChar":"","name":"宁海县"},{"code":330281,"firstChar":"","name":"余姚市"},{"code":330282,"firstChar":"","name":"慈溪市"},{"code":330283,"firstChar":"","name":"奉化市"}]},{"code":101210500,"firstChar":"s","name":"绍兴","subLevelModelList":[{"code":330602,"firstChar":"","name":"越城区"},{"code":330603,"firstChar":"","name":"柯桥区"},{"code":330604,"firstChar":"","name":"上虞区"},{"code":330624,"firstChar":"","name":"新昌县"},{"code":330681,"firstChar":"","name":"诸暨市"},{"code":330683,"firstChar":"","name":"嵊州市"}]},{"code":101210600,"firstChar":"t","name":"台州","subLevelModelList":[{"code":331002,"firstChar":"","name":"椒江区"},{"code":331003,"firstChar":"","name":"黄岩区"},{"code":331004,"firstChar":"","name":"路桥区"},{"code":331021,"firstChar":"","name":"玉环县"},{"code":331022,"firstChar":"","name":"三门县"},{"code":331023,"firstChar":"","name":"天台县"},{"code":331024,"firstChar":"","name":"仙居县"},{"code":331081,"firstChar":"","name":"温岭市"},{"code":331082,"firstChar":"","name":"临海市"}]},{"code":101210700,"firstChar":"w","name":"温州","subLevelModelList":[{"code":330302,"firstChar":"","name":"鹿城区"},{"code":330303,"firstChar":"","name":"龙湾区"},{"code":330304,"firstChar":"","name":"瓯海区"},{"code":330305,"firstChar":"","name":"洞头区"},{"code":330324,"firstChar":"","name":"永嘉县"},{"code":330326,"firstChar":"","name":"平阳县"},{"code":330327,"firstChar":"","name":"苍南县"},{"code":330328,"firstChar":"","name":"文成县"},{"code":330329,"firstChar":"","name":"泰顺县"},{"code":330381,"firstChar":"","name":"瑞安市"},{"code":330382,"firstChar":"","name":"乐清市"}]},{"code":101210800,"firstChar":"l","name":"丽水","subLevelModelList":[{"code":331102,"firstChar":"","name":"莲都区"},{"code":331121,"firstChar":"","name":"青田县"},{"code":331122,"firstChar":"","name":"缙云县"},{"code":331123,"firstChar":"","name":"遂昌县"},{"code":331124,"firstChar":"","name":"松阳县"},{"code":331125,"firstChar":"","name":"云和县"},{"code":331126,"firstChar":"","name":"庆元县"},{"code":331127,"firstChar":"","name":"景宁畲族自治县"},{"code":331181,"firstChar":"","name":"龙泉市"}]},{"code":101210900,"firstChar":"j","name":"金华","subLevelModelList":[{"code":330702,"firstChar":"","name":"婺城区"},{"code":330703,"firstChar":"","name":"金东区"},{"code":330723,"firstChar":"","name":"武义县"},{"code":330726,"firstChar":"","name":"浦江县"},{"code":330727,"firstChar":"","name":"磐安县"},{"code":330781,"firstChar":"","name":"兰溪市"},{"code":330782,"firstChar":"","name":"义乌市"},{"code":330783,"firstChar":"","name":"东阳市"},{"code":330784,"firstChar":"","name":"永康市"}]},{"code":101211000,"firstChar":"q","name":"衢州","subLevelModelList":[{"code":330802,"firstChar":"","name":"柯城区"},{"code":330803,"firstChar":"","name":"衢江区"},{"code":330822,"firstChar":"","name":"常山县"},{"code":330824,"firstChar":"","name":"开化县"},{"code":330825,"firstChar":"","name":"龙游县"},{"code":330881,"firstChar":"","name":"江山市"}]},{"code":101211100,"firstChar":"z","name":"舟山","subLevelModelList":[{"code":330902,"firstChar":"","name":"定海区"},{"code":330903,"firstChar":"","name":"普陀区"},{"code":330921,"firstChar":"","name":"岱山县"},{"code":330922,"firstChar":"","name":"嵊泗县"}]}]},{"code":101220000,"firstChar":"a","name":"安徽","subLevelModelList":[{"code":101220100,"firstChar":"h","name":"合肥","subLevelModelList":[{"code":340102,"firstChar":"","name":"瑶海区"},{"code":340103,"firstChar":"","name":"庐阳区"},{"code":340104,"firstChar":"","name":"蜀山区"},{"code":340111,"firstChar":"","name":"包河区"},{"code":340121,"firstChar":"","name":"长丰县"},{"code":340122,"firstChar":"","name":"肥东县"},{"code":340123,"firstChar":"","name":"肥西县"},{"code":340124,"firstChar":"","name":"庐江县"},{"code":340181,"firstChar":"","name":"巢湖市"}]},{"code":101220200,"firstChar":"b","name":"蚌埠","subLevelModelList":[{"code":340302,"firstChar":"","name":"龙子湖区"},{"code":340303,"firstChar":"","name":"蚌山区"},{"code":340304,"firstChar":"","name":"禹会区"},{"code":340311,"firstChar":"","name":"淮上区"},{"code":340321,"firstChar":"","name":"怀远县"},{"code":340322,"firstChar":"","name":"五河县"},{"code":340323,"firstChar":"","name":"固镇县"}]},{"code":101220300,"firstChar":"w","name":"芜湖","subLevelModelList":[{"code":340202,"firstChar":"","name":"镜湖区"},{"code":340203,"firstChar":"","name":"弋江区"},{"code":340207,"firstChar":"","name":"鸠江区"},{"code":340208,"firstChar":"","name":"三山区"},{"code":340222,"firstChar":"","name":"繁昌县"},{"code":340223,"firstChar":"","name":"南陵县"},{"code":340225,"firstChar":"","name":"无为县"}]},{"code":101220400,"firstChar":"h","name":"淮南","subLevelModelList":[{"code":340402,"firstChar":"","name":"大通区"},{"code":340403,"firstChar":"","name":"田家庵区"},{"code":340404,"firstChar":"","name":"谢家集区"},{"code":340405,"firstChar":"","name":"八公山区"},{"code":340406,"firstChar":"","name":"潘集区"},{"code":340421,"firstChar":"","name":"凤台县"},{"code":340422,"firstChar":"","name":"寿县"}]},{"code":101220500,"firstChar":"m","name":"马鞍山","subLevelModelList":[{"code":340503,"firstChar":"","name":"花山区"},{"code":340504,"firstChar":"","name":"雨山区"},{"code":340506,"firstChar":"","name":"博望区"},{"code":340521,"firstChar":"","name":"当涂县"},{"code":340522,"firstChar":"","name":"含山县"},{"code":340523,"firstChar":"","name":"和县"}]},{"code":101220600,"firstChar":"a","name":"安庆","subLevelModelList":[{"code":340802,"firstChar":"","name":"迎江区"},{"code":340803,"firstChar":"","name":"大观区"},{"code":340811,"firstChar":"","name":"宜秀区"},{"code":340822,"firstChar":"","name":"怀宁县"},{"code":340824,"firstChar":"","name":"潜山县"},{"code":340825,"firstChar":"","name":"太湖县"},{"code":340826,"firstChar":"","name":"宿松县"},{"code":340827,"firstChar":"","name":"望江县"},{"code":340828,"firstChar":"","name":"岳西县"},{"code":340881,"firstChar":"","name":"桐城市"}]},{"code":101220700,"firstChar":"s","name":"宿州","subLevelModelList":[{"code":341302,"firstChar":"","name":"埇桥区"},{"code":341321,"firstChar":"","name":"砀山县"},{"code":341322,"firstChar":"","name":"萧县"},{"code":341323,"firstChar":"","name":"灵璧县"},{"code":341324,"firstChar":"","name":"泗县"}]},{"code":101220800,"firstChar":"f","name":"阜阳","subLevelModelList":[{"code":341202,"firstChar":"","name":"颍州区"},{"code":341203,"firstChar":"","name":"颍东区"},{"code":341204,"firstChar":"","name":"颍泉区"},{"code":341221,"firstChar":"","name":"临泉县"},{"code":341222,"firstChar":"","name":"太和县"},{"code":341225,"firstChar":"","name":"阜南县"},{"code":341226,"firstChar":"","name":"颍上县"},{"code":341282,"firstChar":"","name":"界首市"}]},{"code":101220900,"firstChar":"b","name":"亳州","subLevelModelList":[{"code":341602,"firstChar":"","name":"谯城区"},{"code":341621,"firstChar":"","name":"涡阳县"},{"code":341622,"firstChar":"","name":"蒙城县"},{"code":341623,"firstChar":"","name":"利辛县"}]},{"code":101221000,"firstChar":"c","name":"滁州","subLevelModelList":[{"code":341102,"firstChar":"","name":"琅琊区"},{"code":341103,"firstChar":"","name":"南谯区"},{"code":341122,"firstChar":"","name":"来安县"},{"code":341124,"firstChar":"","name":"全椒县"},{"code":341125,"firstChar":"","name":"定远县"},{"code":341126,"firstChar":"","name":"凤阳县"},{"code":341181,"firstChar":"","name":"天长市"},{"code":341182,"firstChar":"","name":"明光市"}]},{"code":101221100,"firstChar":"h","name":"淮北","subLevelModelList":[{"code":340602,"firstChar":"","name":"杜集区"},{"code":340603,"firstChar":"","name":"相山区"},{"code":340604,"firstChar":"","name":"烈山区"},{"code":340621,"firstChar":"","name":"濉溪县"}]},{"code":101221200,"firstChar":"t","name":"铜陵","subLevelModelList":[{"code":340705,"firstChar":"","name":"铜官区"},{"code":340711,"firstChar":"","name":"郊区"},{"code":340706,"firstChar":"","name":"义安区"},{"code":340722,"firstChar":"","name":"枞阳县"}]},{"code":101221300,"firstChar":"x","name":"宣城","subLevelModelList":[{"code":341802,"firstChar":"","name":"宣州区"},{"code":341821,"firstChar":"","name":"郎溪县"},{"code":341822,"firstChar":"","name":"广德县"},{"code":341823,"firstChar":"","name":"泾县"},{"code":341824,"firstChar":"","name":"绩溪县"},{"code":341825,"firstChar":"","name":"旌德县"},{"code":341881,"firstChar":"","name":"宁国市"}]},{"code":101221400,"firstChar":"l","name":"六安","subLevelModelList":[{"code":341502,"firstChar":"","name":"金安区"},{"code":341503,"firstChar":"","name":"裕安区"},{"code":341504,"firstChar":"","name":"叶集区"},{"code":341522,"firstChar":"","name":"霍邱县"},{"code":341523,"firstChar":"","name":"舒城县"},{"code":341524,"firstChar":"","name":"金寨县"},{"code":341525,"firstChar":"","name":"霍山县"}]},{"code":101221500,"firstChar":"c","name":"池州","subLevelModelList":[{"code":341702,"firstChar":"","name":"贵池区"},{"code":341721,"firstChar":"","name":"东至县"},{"code":341722,"firstChar":"","name":"石台县"},{"code":341723,"firstChar":"","name":"青阳县"}]},{"code":101221600,"firstChar":"h","name":"黄山","subLevelModelList":[{"code":341002,"firstChar":"","name":"屯溪区"},{"code":341004,"firstChar":"","name":"徽州区"},{"code":341021,"firstChar":"","name":"歙县"},{"code":341022,"firstChar":"","name":"休宁县"},{"code":341023,"firstChar":"","name":"黟县"},{"code":341024,"firstChar":"","name":"祁门县"}]}]},{"code":101230000,"firstChar":"f","name":"福建","subLevelModelList":[{"code":101230100,"firstChar":"f","name":"福州","subLevelModelList":[{"code":350102,"firstChar":"","name":"鼓楼区"},{"code":350103,"firstChar":"","name":"台江区"},{"code":350104,"firstChar":"","name":"仓山区"},{"code":350105,"firstChar":"","name":"马尾区"},{"code":350111,"firstChar":"","name":"晋安区"},{"code":350121,"firstChar":"","name":"闽侯县"},{"code":350122,"firstChar":"","name":"连江县"},{"code":350123,"firstChar":"","name":"罗源县"},{"code":350124,"firstChar":"","name":"闽清县"},{"code":350125,"firstChar":"","name":"永泰县"},{"code":350128,"firstChar":"","name":"平潭县"},{"code":350181,"firstChar":"","name":"福清市"},{"code":350182,"firstChar":"","name":"长乐市"}]},{"code":101230200,"firstChar":"x","name":"厦门","subLevelModelList":[{"code":350203,"firstChar":"","name":"思明区"},{"code":350205,"firstChar":"","name":"海沧区"},{"code":350206,"firstChar":"","name":"湖里区"},{"code":350211,"firstChar":"","name":"集美区"},{"code":350212,"firstChar":"","name":"同安区"},{"code":350213,"firstChar":"","name":"翔安区"}]},{"code":101230300,"firstChar":"n","name":"宁德","subLevelModelList":[{"code":350902,"firstChar":"","name":"蕉城区"},{"code":350921,"firstChar":"","name":"霞浦县"},{"code":350922,"firstChar":"","name":"古田县"},{"code":350923,"firstChar":"","name":"屏南县"},{"code":350924,"firstChar":"","name":"寿宁县"},{"code":350925,"firstChar":"","name":"周宁县"},{"code":350926,"firstChar":"","name":"柘荣县"},{"code":350981,"firstChar":"","name":"福安市"},{"code":350982,"firstChar":"","name":"福鼎市"}]},{"code":101230400,"firstChar":"p","name":"莆田","subLevelModelList":[{"code":350302,"firstChar":"","name":"城厢区"},{"code":350303,"firstChar":"","name":"涵江区"},{"code":350304,"firstChar":"","name":"荔城区"},{"code":350305,"firstChar":"","name":"秀屿区"},{"code":350322,"firstChar":"","name":"仙游县"}]},{"code":101230500,"firstChar":"q","name":"泉州","subLevelModelList":[{"code":350502,"firstChar":"","name":"鲤城区"},{"code":350503,"firstChar":"","name":"丰泽区"},{"code":350504,"firstChar":"","name":"洛江区"},{"code":350505,"firstChar":"","name":"泉港区"},{"code":350521,"firstChar":"","name":"惠安县"},{"code":350524,"firstChar":"","name":"安溪县"},{"code":350525,"firstChar":"","name":"永春县"},{"code":350526,"firstChar":"","name":"德化县"},{"code":350527,"firstChar":"","name":"金门县"},{"code":350581,"firstChar":"","name":"石狮市"},{"code":350582,"firstChar":"","name":"晋江市"},{"code":350583,"firstChar":"","name":"南安市"}]},{"code":101230600,"firstChar":"z","name":"漳州","subLevelModelList":[{"code":350602,"firstChar":"","name":"芗城区"},{"code":350603,"firstChar":"","name":"龙文区"},{"code":350622,"firstChar":"","name":"云霄县"},{"code":350623,"firstChar":"","name":"漳浦县"},{"code":350624,"firstChar":"","name":"诏安县"},{"code":350625,"firstChar":"","name":"长泰县"},{"code":350626,"firstChar":"","name":"东山县"},{"code":350627,"firstChar":"","name":"南靖县"},{"code":350628,"firstChar":"","name":"平和县"},{"code":350629,"firstChar":"","name":"华安县"},{"code":350681,"firstChar":"","name":"龙海市"}]},{"code":101230700,"firstChar":"l","name":"龙岩","subLevelModelList":[{"code":350802,"firstChar":"","name":"新罗区"},{"code":350803,"firstChar":"","name":"永定区"},{"code":350821,"firstChar":"","name":"长汀县"},{"code":350823,"firstChar":"","name":"上杭县"},{"code":350824,"firstChar":"","name":"武平县"},{"code":350825,"firstChar":"","name":"连城县"},{"code":350881,"firstChar":"","name":"漳平市"}]},{"code":101230800,"firstChar":"s","name":"三明","subLevelModelList":[{"code":350402,"firstChar":"","name":"梅列区"},{"code":350403,"firstChar":"","name":"三元区"},{"code":350421,"firstChar":"","name":"明溪县"},{"code":350423,"firstChar":"","name":"清流县"},{"code":350424,"firstChar":"","name":"宁化县"},{"code":350425,"firstChar":"","name":"大田县"},{"code":350426,"firstChar":"","name":"尤溪县"},{"code":350427,"firstChar":"","name":"沙县"},{"code":350428,"firstChar":"","name":"将乐县"},{"code":350429,"firstChar":"","name":"泰宁县"},{"code":350430,"firstChar":"","name":"建宁县"},{"code":350481,"firstChar":"","name":"永安市"}]},{"code":101230900,"firstChar":"n","name":"南平","subLevelModelList":[{"code":350702,"firstChar":"","name":"延平区"},{"code":350703,"firstChar":"","name":"建阳区"},{"code":350721,"firstChar":"","name":"顺昌县"},{"code":350722,"firstChar":"","name":"浦城县"},{"code":350723,"firstChar":"","name":"光泽县"},{"code":350724,"firstChar":"","name":"松溪县"},{"code":350725,"firstChar":"","name":"政和县"},{"code":350781,"firstChar":"","name":"邵武市"},{"code":350782,"firstChar":"","name":"武夷山市"},{"code":350783,"firstChar":"","name":"建瓯市"}]}]},{"code":101240000,"firstChar":"j","name":"江西","subLevelModelList":[{"code":101240100,"firstChar":"n","name":"南昌","subLevelModelList":[{"code":360102,"firstChar":"","name":"东湖区"},{"code":360103,"firstChar":"","name":"西湖区"},{"code":360104,"firstChar":"","name":"青云谱区"},{"code":360105,"firstChar":"","name":"湾里区"},{"code":360111,"firstChar":"","name":"青山湖区"},{"code":360112,"firstChar":"","name":"新建区"},{"code":360123,"firstChar":"","name":"安义县"},{"code":360124,"firstChar":"","name":"进贤县"}]},{"code":101240200,"firstChar":"j","name":"九江","subLevelModelList":[{"code":360402,"firstChar":"","name":"濂溪区"},{"code":360403,"firstChar":"","name":"浔阳区"},{"code":360423,"firstChar":"","name":"武宁县"},{"code":360424,"firstChar":"","name":"修水县"},{"code":360425,"firstChar":"","name":"永修县"},{"code":360426,"firstChar":"","name":"德安县"},{"code":360427,"firstChar":"","name":"庐山市"},{"code":360428,"firstChar":"","name":"都昌县"},{"code":360429,"firstChar":"","name":"湖口县"},{"code":360430,"firstChar":"","name":"彭泽县"},{"code":360481,"firstChar":"","name":"瑞昌市"},{"code":360482,"firstChar":"","name":"共青城市"}]},{"code":101240300,"firstChar":"s","name":"上饶","subLevelModelList":[{"code":361102,"firstChar":"","name":"信州区"},{"code":361103,"firstChar":"","name":"广丰区"},{"code":361123,"firstChar":"","name":"玉山县"},{"code":361124,"firstChar":"","name":"铅山县"},{"code":361125,"firstChar":"","name":"横峰县"},{"code":361126,"firstChar":"","name":"弋阳县"},{"code":361127,"firstChar":"","name":"余干县"},{"code":361128,"firstChar":"","name":"鄱阳县"},{"code":361129,"firstChar":"","name":"万年县"},{"code":361130,"firstChar":"","name":"婺源县"},{"code":361181,"firstChar":"","name":"德兴市"}]},{"code":101240400,"firstChar":"f","name":"抚州","subLevelModelList":[{"code":361002,"firstChar":"","name":"临川区"},{"code":361021,"firstChar":"","name":"南城县"},{"code":361022,"firstChar":"","name":"黎川县"},{"code":361023,"firstChar":"","name":"南丰县"},{"code":361024,"firstChar":"","name":"崇仁县"},{"code":361025,"firstChar":"","name":"乐安县"},{"code":361026,"firstChar":"","name":"宜黄县"},{"code":361027,"firstChar":"","name":"金溪县"},{"code":361028,"firstChar":"","name":"资溪县"},{"code":361029,"firstChar":"","name":"东乡县"},{"code":361030,"firstChar":"","name":"广昌县"}]},{"code":101240500,"firstChar":"y","name":"宜春","subLevelModelList":[{"code":360902,"firstChar":"","name":"袁州区"},{"code":360921,"firstChar":"","name":"奉新县"},{"code":360922,"firstChar":"","name":"万载县"},{"code":360923,"firstChar":"","name":"上高县"},{"code":360924,"firstChar":"","name":"宜丰县"},{"code":360925,"firstChar":"","name":"靖安县"},{"code":360926,"firstChar":"","name":"铜鼓县"},{"code":360981,"firstChar":"","name":"丰城市"},{"code":360982,"firstChar":"","name":"樟树市"},{"code":360983,"firstChar":"","name":"高安市"}]},{"code":101240600,"firstChar":"j","name":"吉安","subLevelModelList":[{"code":360802,"firstChar":"","name":"吉州区"},{"code":360803,"firstChar":"","name":"青原区"},{"code":360822,"firstChar":"","name":"吉水县"},{"code":360823,"firstChar":"","name":"峡江县"},{"code":360824,"firstChar":"","name":"新干县"},{"code":360825,"firstChar":"","name":"永丰县"},{"code":360826,"firstChar":"","name":"泰和县"},{"code":360827,"firstChar":"","name":"遂川县"},{"code":360828,"firstChar":"","name":"万安县"},{"code":360829,"firstChar":"","name":"安福县"},{"code":360830,"firstChar":"","name":"永新县"},{"code":360881,"firstChar":"","name":"井冈山市"}]},{"code":101240700,"firstChar":"g","name":"赣州","subLevelModelList":[{"code":360702,"firstChar":"","name":"章贡区"},{"code":360703,"firstChar":"","name":"南康区"},{"code":360721,"firstChar":"","name":"赣县"},{"code":360722,"firstChar":"","name":"信丰县"},{"code":360723,"firstChar":"","name":"大余县"},{"code":360724,"firstChar":"","name":"上犹县"},{"code":360725,"firstChar":"","name":"崇义县"},{"code":360726,"firstChar":"","name":"安远县"},{"code":360727,"firstChar":"","name":"龙南县"},{"code":360728,"firstChar":"","name":"定南县"},{"code":360729,"firstChar":"","name":"全南县"},{"code":360730,"firstChar":"","name":"宁都县"},{"code":360731,"firstChar":"","name":"于都县"},{"code":360732,"firstChar":"","name":"兴国县"},{"code":360733,"firstChar":"","name":"会昌县"},{"code":360734,"firstChar":"","name":"寻乌县"},{"code":360735,"firstChar":"","name":"石城县"},{"code":360781,"firstChar":"","name":"瑞金市"}]},{"code":101240800,"firstChar":"j","name":"景德镇","subLevelModelList":[{"code":360202,"firstChar":"","name":"昌江区"},{"code":360203,"firstChar":"","name":"珠山区"},{"code":360222,"firstChar":"","name":"浮梁县"},{"code":360281,"firstChar":"","name":"乐平市"}]},{"code":101240900,"firstChar":"p","name":"萍乡","subLevelModelList":[{"code":360302,"firstChar":"","name":"安源区"},{"code":360313,"firstChar":"","name":"湘东区"},{"code":360321,"firstChar":"","name":"莲花县"},{"code":360322,"firstChar":"","name":"上栗县"},{"code":360323,"firstChar":"","name":"芦溪县"}]},{"code":101241000,"firstChar":"x","name":"新余","subLevelModelList":[{"code":360502,"firstChar":"","name":"渝水区"},{"code":360521,"firstChar":"","name":"分宜县"}]},{"code":101241100,"firstChar":"y","name":"鹰潭","subLevelModelList":[{"code":360602,"firstChar":"","name":"月湖区"},{"code":360622,"firstChar":"","name":"余江县"},{"code":360681,"firstChar":"","name":"贵溪市"}]}]},{"code":101250000,"firstChar":"h","name":"湖南","subLevelModelList":[{"code":101250100,"firstChar":"c","name":"长沙","subLevelModelList":[{"code":430102,"firstChar":"","name":"芙蓉区"},{"code":430103,"firstChar":"","name":"天心区"},{"code":430104,"firstChar":"","name":"岳麓区"},{"code":430105,"firstChar":"","name":"开福区"},{"code":430111,"firstChar":"","name":"雨花区"},{"code":430112,"firstChar":"","name":"望城区"},{"code":430124,"firstChar":"","name":"宁乡县"},{"code":430181,"firstChar":"","name":"浏阳市"}]},{"code":101250200,"firstChar":"x","name":"湘潭","subLevelModelList":[{"code":430302,"firstChar":"","name":"雨湖区"},{"code":430304,"firstChar":"","name":"岳塘区"},{"code":430381,"firstChar":"","name":"湘乡市"},{"code":430382,"firstChar":"","name":"韶山市"}]},{"code":101250300,"firstChar":"z","name":"株洲","subLevelModelList":[{"code":430202,"firstChar":"","name":"荷塘区"},{"code":430203,"firstChar":"","name":"芦淞区"},{"code":430204,"firstChar":"","name":"石峰区"},{"code":430211,"firstChar":"","name":"天元区"},{"code":430223,"firstChar":"","name":"攸县"},{"code":430224,"firstChar":"","name":"茶陵县"},{"code":430225,"firstChar":"","name":"炎陵县"},{"code":430281,"firstChar":"","name":"醴陵市"}]},{"code":101250400,"firstChar":"h","name":"衡阳","subLevelModelList":[{"code":430405,"firstChar":"","name":"珠晖区"},{"code":430406,"firstChar":"","name":"雁峰区"},{"code":430407,"firstChar":"","name":"石鼓区"},{"code":430408,"firstChar":"","name":"蒸湘区"},{"code":430412,"firstChar":"","name":"南岳区"},{"code":430422,"firstChar":"","name":"衡南县"},{"code":430423,"firstChar":"","name":"衡山县"},{"code":430424,"firstChar":"","name":"衡东县"},{"code":430426,"firstChar":"","name":"祁东县"},{"code":430481,"firstChar":"","name":"耒阳市"},{"code":430482,"firstChar":"","name":"常宁市"}]},{"code":101250500,"firstChar":"c","name":"郴州","subLevelModelList":[{"code":431002,"firstChar":"","name":"北湖区"},{"code":431003,"firstChar":"","name":"苏仙区"},{"code":431021,"firstChar":"","name":"桂阳县"},{"code":431022,"firstChar":"","name":"宜章县"},{"code":431023,"firstChar":"","name":"永兴县"},{"code":431024,"firstChar":"","name":"嘉禾县"},{"code":431025,"firstChar":"","name":"临武县"},{"code":431026,"firstChar":"","name":"汝城县"},{"code":431027,"firstChar":"","name":"桂东县"},{"code":431028,"firstChar":"","name":"安仁县"},{"code":431081,"firstChar":"","name":"资兴市"}]},{"code":101250600,"firstChar":"c","name":"常德","subLevelModelList":[{"code":430702,"firstChar":"","name":"武陵区"},{"code":430703,"firstChar":"","name":"鼎城区"},{"code":430721,"firstChar":"","name":"安乡县"},{"code":430722,"firstChar":"","name":"汉寿县"},{"code":430723,"firstChar":"","name":"澧县"},{"code":430724,"firstChar":"","name":"临澧县"},{"code":430725,"firstChar":"","name":"桃源县"},{"code":430726,"firstChar":"","name":"石门县"},{"code":430781,"firstChar":"","name":"津市市"}]},{"code":101250700,"firstChar":"y","name":"益阳","subLevelModelList":[{"code":430902,"firstChar":"","name":"资阳区"},{"code":430903,"firstChar":"","name":"赫山区"},{"code":430921,"firstChar":"","name":"南县"},{"code":430922,"firstChar":"","name":"桃江县"},{"code":430923,"firstChar":"","name":"安化县"},{"code":430981,"firstChar":"","name":"沅江市"}]},{"code":101250800,"firstChar":"l","name":"娄底","subLevelModelList":[{"code":431302,"firstChar":"","name":"娄星区"},{"code":431321,"firstChar":"","name":"双峰县"},{"code":431322,"firstChar":"","name":"新化县"},{"code":431381,"firstChar":"","name":"冷水江市"},{"code":431382,"firstChar":"","name":"涟源市"}]},{"code":101250900,"firstChar":"s","name":"邵阳","subLevelModelList":[{"code":430502,"firstChar":"","name":"双清区"},{"code":430503,"firstChar":"","name":"大祥区"},{"code":430511,"firstChar":"","name":"北塔区"},{"code":430521,"firstChar":"","name":"邵东县"},{"code":430522,"firstChar":"","name":"新邵县"},{"code":430524,"firstChar":"","name":"隆回县"},{"code":430525,"firstChar":"","name":"洞口县"},{"code":430527,"firstChar":"","name":"绥宁县"},{"code":430528,"firstChar":"","name":"新宁县"},{"code":430529,"firstChar":"","name":"城步苗族自治县"},{"code":430581,"firstChar":"","name":"武冈市"}]},{"code":101251000,"firstChar":"y","name":"岳阳","subLevelModelList":[{"code":430603,"firstChar":"","name":"云溪区"},{"code":430611,"firstChar":"","name":"君山区"},{"code":430623,"firstChar":"","name":"华容县"},{"code":430624,"firstChar":"","name":"湘阴县"},{"code":430626,"firstChar":"","name":"平江县"},{"code":430681,"firstChar":"","name":"汨罗市"},{"code":430682,"firstChar":"","name":"临湘市"}]},{"code":101251100,"firstChar":"z","name":"张家界","subLevelModelList":[{"code":430802,"firstChar":"","name":"永定区"},{"code":430811,"firstChar":"","name":"武陵源区"},{"code":430821,"firstChar":"","name":"慈利县"},{"code":430822,"firstChar":"","name":"桑植县"}]},{"code":101251200,"firstChar":"h","name":"怀化","subLevelModelList":[{"code":431202,"firstChar":"","name":"鹤城区"},{"code":431221,"firstChar":"","name":"中方县"},{"code":431222,"firstChar":"","name":"沅陵县"},{"code":431223,"firstChar":"","name":"辰溪县"},{"code":431224,"firstChar":"","name":"溆浦县"},{"code":431225,"firstChar":"","name":"会同县"},{"code":431226,"firstChar":"","name":"麻阳苗族自治县"},{"code":431227,"firstChar":"","name":"新晃侗族自治县"},{"code":431228,"firstChar":"","name":"芷江侗族自治县"},{"code":431229,"firstChar":"","name":"靖州苗族侗族自治县"},{"code":431230,"firstChar":"","name":"通道侗族自治县"},{"code":431281,"firstChar":"","name":"洪江市"}]},{"code":101251300,"firstChar":"y","name":"永州","subLevelModelList":[{"code":431102,"firstChar":"","name":"零陵区"},{"code":431103,"firstChar":"","name":"冷水滩区"},{"code":431121,"firstChar":"","name":"祁阳县"},{"code":431122,"firstChar":"","name":"东安县"},{"code":431123,"firstChar":"","name":"双牌县"},{"code":431124,"firstChar":"","name":"道县"},{"code":431125,"firstChar":"","name":"江永县"},{"code":431126,"firstChar":"","name":"宁远县"},{"code":431127,"firstChar":"","name":"蓝山县"},{"code":431128,"firstChar":"","name":"新田县"},{"code":431129,"firstChar":"","name":"江华瑶族自治县"}]},{"code":101251400,"firstChar":"x","name":"湘西","subLevelModelList":[{"code":433101,"firstChar":"","name":"吉首市"},{"code":433122,"firstChar":"","name":"泸溪县"},{"code":433123,"firstChar":"","name":"凤凰县"},{"code":433124,"firstChar":"","name":"花垣县"},{"code":433125,"firstChar":"","name":"保靖县"},{"code":433126,"firstChar":"","name":"古丈县"},{"code":433127,"firstChar":"","name":"永顺县"},{"code":433130,"firstChar":"","name":"龙山县"}]}]},{"code":101260000,"firstChar":"g","name":"贵州","subLevelModelList":[{"code":101260100,"firstChar":"g","name":"贵阳","subLevelModelList":[{"code":520102,"firstChar":"","name":"南明区"},{"code":520103,"firstChar":"","name":"云岩区"},{"code":520111,"firstChar":"","name":"花溪区"},{"code":520112,"firstChar":"","name":"乌当区"},{"code":520113,"firstChar":"","name":"白云区"},{"code":520115,"firstChar":"","name":"观山湖区"},{"code":520121,"firstChar":"","name":"开阳县"},{"code":520122,"firstChar":"","name":"息烽县"},{"code":520123,"firstChar":"","name":"修文县"},{"code":520181,"firstChar":"","name":"清镇市"}]},{"code":101260200,"firstChar":"z","name":"遵义","subLevelModelList":[{"code":520302,"firstChar":"","name":"红花岗区"},{"code":520303,"firstChar":"","name":"汇川区"},{"code":520321,"firstChar":"","name":"播州区"},{"code":520322,"firstChar":"","name":"桐梓县"},{"code":520323,"firstChar":"","name":"绥阳县"},{"code":520324,"firstChar":"","name":"正安县"},{"code":520325,"firstChar":"","name":"道真仡佬族苗族自治县"},{"code":520326,"firstChar":"","name":"务川仡佬族苗族自治县"},{"code":520327,"firstChar":"","name":"凤冈县"},{"code":520328,"firstChar":"","name":"湄潭县"},{"code":520329,"firstChar":"","name":"余庆县"},{"code":520330,"firstChar":"","name":"习水县"},{"code":520381,"firstChar":"","name":"赤水市"},{"code":520382,"firstChar":"","name":"仁怀市"}]},{"code":101260300,"firstChar":"a","name":"安顺","subLevelModelList":[{"code":520402,"firstChar":"","name":"西秀区"},{"code":520403,"firstChar":"","name":"平坝区"},{"code":520422,"firstChar":"","name":"普定县"},{"code":520423,"firstChar":"","name":"镇宁布依族苗族自治县"},{"code":520424,"firstChar":"","name":"关岭布依族苗族自治县"},{"code":520425,"firstChar":"","name":"紫云苗族布依族自治县"}]},{"code":101260400,"firstChar":"t","name":"铜仁","subLevelModelList":[{"code":520602,"firstChar":"","name":"碧江区"},{"code":520603,"firstChar":"","name":"万山区"},{"code":520621,"firstChar":"","name":"江口县"},{"code":520622,"firstChar":"","name":"玉屏侗族自治县"},{"code":520623,"firstChar":"","name":"石阡县"},{"code":520624,"firstChar":"","name":"思南县"},{"code":520625,"firstChar":"","name":"印江土家族苗族自治县"},{"code":520626,"firstChar":"","name":"德江县"},{"code":520627,"firstChar":"","name":"沿河土家族自治县"},{"code":520628,"firstChar":"","name":"松桃苗族自治县"}]},{"code":101260500,"firstChar":"b","name":"毕节","subLevelModelList":[{"code":520502,"firstChar":"","name":"七星关区"},{"code":520521,"firstChar":"","name":"大方县"},{"code":520522,"firstChar":"","name":"黔西县"},{"code":520523,"firstChar":"","name":"金沙县"},{"code":520524,"firstChar":"","name":"织金县"},{"code":520525,"firstChar":"","name":"纳雍县"},{"code":520526,"firstChar":"","name":"威宁彝族回族苗族自治县"},{"code":520527,"firstChar":"","name":"赫章县"}]},{"code":101260600,"firstChar":"l","name":"六盘水","subLevelModelList":[{"code":520201,"firstChar":"","name":"钟山区"},{"code":520203,"firstChar":"","name":"六枝特区"},{"code":520221,"firstChar":"","name":"水城县"},{"code":520222,"firstChar":"","name":"盘县"}]},{"code":101260700,"firstChar":"q","name":"黔东南","subLevelModelList":[{"code":522601,"firstChar":"","name":"凯里市"},{"code":522622,"firstChar":"","name":"黄平县"},{"code":522623,"firstChar":"","name":"施秉县"},{"code":522624,"firstChar":"","name":"三穗县"},{"code":522625,"firstChar":"","name":"镇远县"},{"code":522626,"firstChar":"","name":"岑巩县"},{"code":522627,"firstChar":"","name":"天柱县"},{"code":522628,"firstChar":"","name":"锦屏县"},{"code":522629,"firstChar":"","name":"剑河县"},{"code":522630,"firstChar":"","name":"台江县"},{"code":522631,"firstChar":"","name":"黎平县"},{"code":522632,"firstChar":"","name":"榕江县"},{"code":522633,"firstChar":"","name":"从江县"},{"code":522634,"firstChar":"","name":"雷山县"},{"code":522635,"firstChar":"","name":"麻江县"},{"code":522636,"firstChar":"","name":"丹寨县"}]},{"code":101260800,"firstChar":"q","name":"黔南","subLevelModelList":[{"code":522701,"firstChar":"","name":"都匀市"},{"code":522702,"firstChar":"","name":"福泉市"},{"code":522722,"firstChar":"","name":"荔波县"},{"code":522723,"firstChar":"","name":"贵定县"},{"code":522725,"firstChar":"","name":"瓮安县"},{"code":522726,"firstChar":"","name":"独山县"},{"code":522727,"firstChar":"","name":"平塘县"},{"code":522728,"firstChar":"","name":"罗甸县"},{"code":522729,"firstChar":"","name":"长顺县"},{"code":522730,"firstChar":"","name":"龙里县"},{"code":522731,"firstChar":"","name":"惠水县"},{"code":522732,"firstChar":"","name":"三都水族自治县"}]},{"code":101260900,"firstChar":"q","name":"黔西南","subLevelModelList":[{"code":522301,"firstChar":"","name":"兴义市"},{"code":522322,"firstChar":"","name":"兴仁县"},{"code":522323,"firstChar":"","name":"普安县"},{"code":522324,"firstChar":"","name":"晴隆县"},{"code":522325,"firstChar":"","name":"贞丰县"},{"code":522326,"firstChar":"","name":"望谟县"},{"code":522327,"firstChar":"","name":"册亨县"},{"code":522328,"firstChar":"","name":"安龙县"}]}]},{"code":101270000,"firstChar":"s","name":"四川","subLevelModelList":[{"code":101270100,"firstChar":"c","name":"成都","subLevelModelList":[{"code":510104,"firstChar":"","name":"锦江区"},{"code":510105,"firstChar":"","name":"青羊区"},{"code":510106,"firstChar":"","name":"金牛区"},{"code":510107,"firstChar":"","name":"武侯区"},{"code":510108,"firstChar":"","name":"成华区"},{"code":510112,"firstChar":"","name":"龙泉驿区"},{"code":510113,"firstChar":"","name":"青白江区"},{"code":510114,"firstChar":"","name":"新都区"},{"code":510115,"firstChar":"","name":"温江区"},{"code":510121,"firstChar":"","name":"金堂县"},{"code":510116,"firstChar":"","name":"双流区"},{"code":510124,"firstChar":"","name":"郫县"},{"code":510129,"firstChar":"","name":"大邑县"},{"code":510131,"firstChar":"","name":"蒲江县"},{"code":510132,"firstChar":"","name":"新津县"},{"code":510180,"firstChar":"","name":"简阳市"},{"code":510181,"firstChar":"","name":"都江堰市"},{"code":510182,"firstChar":"","name":"彭州市"},{"code":510183,"firstChar":"","name":"邛崃市"},{"code":510184,"firstChar":"","name":"崇州市"}]},{"code":101270200,"firstChar":"p","name":"攀枝花","subLevelModelList":[{"code":510402,"firstChar":"","name":"东区"},{"code":510403,"firstChar":"","name":"西区"},{"code":510411,"firstChar":"","name":"仁和区"},{"code":510421,"firstChar":"","name":"米易县"},{"code":510422,"firstChar":"","name":"盐边县"}]},{"code":101270300,"firstChar":"z","name":"自贡","subLevelModelList":[{"code":510302,"firstChar":"","name":"自流井区"},{"code":510303,"firstChar":"","name":"贡井区"},{"code":510304,"firstChar":"","name":"大安区"},{"code":510311,"firstChar":"","name":"沿滩区"},{"code":510321,"firstChar":"","name":"荣县"},{"code":510322,"firstChar":"","name":"富顺县"}]},{"code":101270400,"firstChar":"m","name":"绵阳","subLevelModelList":[{"code":510703,"firstChar":"","name":"涪城区"},{"code":510704,"firstChar":"","name":"游仙区"},{"code":510722,"firstChar":"","name":"三台县"},{"code":510723,"firstChar":"","name":"盐亭县"},{"code":510724,"firstChar":"","name":"安州区"},{"code":510725,"firstChar":"","name":"梓潼县"},{"code":510726,"firstChar":"","name":"北川羌族自治县"},{"code":510727,"firstChar":"","name":"平武县"},{"code":510781,"firstChar":"","name":"江油市"}]},{"code":101270500,"firstChar":"n","name":"南充","subLevelModelList":[{"code":511302,"firstChar":"","name":"顺庆区"},{"code":511303,"firstChar":"","name":"高坪区"},{"code":511304,"firstChar":"","name":"嘉陵区"},{"code":511321,"firstChar":"","name":"南部县"},{"code":511322,"firstChar":"","name":"营山县"},{"code":511323,"firstChar":"","name":"蓬安县"},{"code":511324,"firstChar":"","name":"仪陇县"},{"code":511325,"firstChar":"","name":"西充县"},{"code":511381,"firstChar":"","name":"阆中市"}]},{"code":101270600,"firstChar":"d","name":"达州","subLevelModelList":[{"code":511702,"firstChar":"","name":"通川区"},{"code":511703,"firstChar":"","name":"达川区"},{"code":511722,"firstChar":"","name":"宣汉县"},{"code":511723,"firstChar":"","name":"开江县"},{"code":511724,"firstChar":"","name":"大竹县"},{"code":511725,"firstChar":"","name":"渠县"},{"code":511781,"firstChar":"","name":"万源市"}]},{"code":101270700,"firstChar":"s","name":"遂宁","subLevelModelList":[{"code":510903,"firstChar":"","name":"船山区"},{"code":510904,"firstChar":"","name":"安居区"},{"code":510921,"firstChar":"","name":"蓬溪县"},{"code":510922,"firstChar":"","name":"射洪县"},{"code":510923,"firstChar":"","name":"大英县"}]},{"code":101270800,"firstChar":"g","name":"广安","subLevelModelList":[{"code":511603,"firstChar":"","name":"前锋区"},{"code":511621,"firstChar":"","name":"岳池县"},{"code":511622,"firstChar":"","name":"武胜县"},{"code":511623,"firstChar":"","name":"邻水县"},{"code":511681,"firstChar":"","name":"华蓥市"}]},{"code":101270900,"firstChar":"b","name":"巴中","subLevelModelList":[{"code":511902,"firstChar":"","name":"巴州区"},{"code":511903,"firstChar":"","name":"恩阳区"},{"code":511921,"firstChar":"","name":"通江县"},{"code":511922,"firstChar":"","name":"南江县"},{"code":511923,"firstChar":"","name":"平昌县"}]},{"code":101271000,"firstChar":"l","name":"泸州","subLevelModelList":[{"code":510502,"firstChar":"","name":"江阳区"},{"code":510503,"firstChar":"","name":"纳溪区"},{"code":510504,"firstChar":"","name":"龙马潭区"},{"code":510521,"firstChar":"","name":"泸县"},{"code":510522,"firstChar":"","name":"合江县"},{"code":510524,"firstChar":"","name":"叙永县"},{"code":510525,"firstChar":"","name":"古蔺县"}]},{"code":101271100,"firstChar":"y","name":"宜宾","subLevelModelList":[{"code":511502,"firstChar":"","name":"翠屏区"},{"code":511503,"firstChar":"","name":"南溪区"},{"code":511523,"firstChar":"","name":"江安县"},{"code":511524,"firstChar":"","name":"长宁县"},{"code":511525,"firstChar":"","name":"高县"},{"code":511526,"firstChar":"","name":"珙县"},{"code":511527,"firstChar":"","name":"筠连县"},{"code":511528,"firstChar":"","name":"兴文县"},{"code":511529,"firstChar":"","name":"屏山县"}]},{"code":101271200,"firstChar":"n","name":"内江","subLevelModelList":[{"code":511002,"firstChar":"","name":"市中区"},{"code":511011,"firstChar":"","name":"东兴区"},{"code":511024,"firstChar":"","name":"威远县"},{"code":511025,"firstChar":"","name":"资中县"},{"code":511028,"firstChar":"","name":"隆昌县"}]},{"code":101271300,"firstChar":"z","name":"资阳","subLevelModelList":[{"code":512002,"firstChar":"","name":"雁江区"},{"code":512021,"firstChar":"","name":"安岳县"},{"code":512022,"firstChar":"","name":"乐至县"}]},{"code":101271400,"firstChar":"l","name":"乐山","subLevelModelList":[{"code":511102,"firstChar":"","name":"市中区"},{"code":511111,"firstChar":"","name":"沙湾区"},{"code":511112,"firstChar":"","name":"五通桥区"},{"code":511113,"firstChar":"","name":"金口河区"},{"code":511123,"firstChar":"","name":"犍为县"},{"code":511124,"firstChar":"","name":"井研县"},{"code":511126,"firstChar":"","name":"夹江县"},{"code":511129,"firstChar":"","name":"沐川县"},{"code":511132,"firstChar":"","name":"峨边彝族自治县"},{"code":511133,"firstChar":"","name":"马边彝族自治县"}]},{"code":101271500,"firstChar":"m","name":"眉山","subLevelModelList":[{"code":511402,"firstChar":"","name":"东坡区"},{"code":511403,"firstChar":"","name":"彭山区"},{"code":511421,"firstChar":"","name":"仁寿县"},{"code":511423,"firstChar":"","name":"洪雅县"},{"code":511424,"firstChar":"","name":"丹棱县"},{"code":511425,"firstChar":"","name":"青神县"}]},{"code":101271600,"firstChar":"y","name":"雅安","subLevelModelList":[{"code":511802,"firstChar":"","name":"雨城区"},{"code":511803,"firstChar":"","name":"名山区"},{"code":511822,"firstChar":"","name":"荥经县"},{"code":511823,"firstChar":"","name":"汉源县"},{"code":511824,"firstChar":"","name":"石棉县"},{"code":511825,"firstChar":"","name":"天全县"},{"code":511826,"firstChar":"","name":"芦山县"},{"code":511827,"firstChar":"","name":"宝兴县"}]},{"code":101271700,"firstChar":"d","name":"德阳","subLevelModelList":[{"code":510603,"firstChar":"","name":"旌阳区"},{"code":510623,"firstChar":"","name":"中江县"},{"code":510626,"firstChar":"","name":"罗江县"},{"code":510681,"firstChar":"","name":"广汉市"},{"code":510682,"firstChar":"","name":"什邡市"},{"code":510683,"firstChar":"","name":"绵竹市"}]},{"code":101271800,"firstChar":"g","name":"广元","subLevelModelList":[{"code":510802,"firstChar":"","name":"利州区"},{"code":510811,"firstChar":"","name":"昭化区"},{"code":510812,"firstChar":"","name":"朝天区"},{"code":510821,"firstChar":"","name":"旺苍县"},{"code":510822,"firstChar":"","name":"青川县"},{"code":510823,"firstChar":"","name":"剑阁县"},{"code":510824,"firstChar":"","name":"苍溪县"}]},{"code":101271900,"firstChar":"e","name":"阿坝","subLevelModelList":[{"code":513221,"firstChar":"","name":"汶川县"},{"code":513222,"firstChar":"","name":"理县"},{"code":513223,"firstChar":"","name":"茂县"},{"code":513224,"firstChar":"","name":"松潘县"},{"code":513225,"firstChar":"","name":"九寨沟县"},{"code":513226,"firstChar":"","name":"金川县"},{"code":513227,"firstChar":"","name":"小金县"},{"code":513228,"firstChar":"","name":"黑水县"},{"code":513201,"firstChar":"","name":"马尔康市"},{"code":513230,"firstChar":"","name":"壤塘县"},{"code":513232,"firstChar":"","name":"若尔盖县"},{"code":513233,"firstChar":"","name":"红原县"}]},{"code":101272000,"firstChar":"l","name":"凉山","subLevelModelList":[{"code":513401,"firstChar":"","name":"西昌市"},{"code":513422,"firstChar":"","name":"木里藏族自治县"},{"code":513423,"firstChar":"","name":"盐源县"},{"code":513424,"firstChar":"","name":"德昌县"},{"code":513425,"firstChar":"","name":"会理县"},{"code":513426,"firstChar":"","name":"会东县"},{"code":513427,"firstChar":"","name":"宁南县"},{"code":513428,"firstChar":"","name":"普格县"},{"code":513429,"firstChar":"","name":"布拖县"},{"code":513430,"firstChar":"","name":"金阳县"},{"code":513431,"firstChar":"","name":"昭觉县"},{"code":513432,"firstChar":"","name":"喜德县"},{"code":513433,"firstChar":"","name":"冕宁县"},{"code":513434,"firstChar":"","name":"越西县"},{"code":513435,"firstChar":"","name":"甘洛县"},{"code":513436,"firstChar":"","name":"美姑县"},{"code":513437,"firstChar":"","name":"雷波县"}]},{"code":101272100,"firstChar":"g","name":"甘孜","subLevelModelList":[{"code":513301,"firstChar":"","name":"康定市"},{"code":513322,"firstChar":"","name":"泸定县"},{"code":513323,"firstChar":"","name":"丹巴县"},{"code":513324,"firstChar":"","name":"九龙县"},{"code":513325,"firstChar":"","name":"雅江县"},{"code":513326,"firstChar":"","name":"道孚县"},{"code":513327,"firstChar":"","name":"炉霍县"},{"code":513329,"firstChar":"","name":"新龙县"},{"code":513330,"firstChar":"","name":"德格县"},{"code":513331,"firstChar":"","name":"白玉县"},{"code":513332,"firstChar":"","name":"石渠县"},{"code":513333,"firstChar":"","name":"色达县"},{"code":513334,"firstChar":"","name":"理塘县"},{"code":513335,"firstChar":"","name":"巴塘县"},{"code":513336,"firstChar":"","name":"乡城县"},{"code":513337,"firstChar":"","name":"稻城县"},{"code":513338,"firstChar":"","name":"得荣县"}]}]},{"code":101280000,"firstChar":"g","name":"广东","subLevelModelList":[{"code":101280100,"firstChar":"g","name":"广州","subLevelModelList":[{"code":440103,"firstChar":"","name":"荔湾区"},{"code":440104,"firstChar":"","name":"越秀区"},{"code":440105,"firstChar":"","name":"海珠区"},{"code":440106,"firstChar":"","name":"天河区"},{"code":440111,"firstChar":"","name":"白云区"},{"code":440112,"firstChar":"","name":"黄埔区"},{"code":440113,"firstChar":"","name":"番禺区"},{"code":440114,"firstChar":"","name":"花都区"},{"code":440115,"firstChar":"","name":"南沙区"},{"code":440117,"firstChar":"","name":"从化区"},{"code":440118,"firstChar":"","name":"增城区"}]},{"code":101280200,"firstChar":"s","name":"韶关","subLevelModelList":[{"code":440203,"firstChar":"","name":"武江区"},{"code":440204,"firstChar":"","name":"浈江区"},{"code":440205,"firstChar":"","name":"曲江区"},{"code":440222,"firstChar":"","name":"始兴县"},{"code":440224,"firstChar":"","name":"仁化县"},{"code":440229,"firstChar":"","name":"翁源县"},{"code":440232,"firstChar":"","name":"乳源瑶族自治县"},{"code":440233,"firstChar":"","name":"新丰县"},{"code":440281,"firstChar":"","name":"乐昌市"},{"code":440282,"firstChar":"","name":"南雄市"}]},{"code":101280300,"firstChar":"h","name":"惠州","subLevelModelList":[{"code":441302,"firstChar":"","name":"惠城区"},{"code":441303,"firstChar":"","name":"惠阳区"},{"code":441322,"firstChar":"","name":"博罗县"},{"code":441323,"firstChar":"","name":"惠东县"},{"code":441324,"firstChar":"","name":"龙门县"}]},{"code":101280400,"firstChar":"m","name":"梅州","subLevelModelList":[{"code":441402,"firstChar":"","name":"梅江区"},{"code":441403,"firstChar":"","name":"梅县区"},{"code":441422,"firstChar":"","name":"大埔县"},{"code":441423,"firstChar":"","name":"丰顺县"},{"code":441424,"firstChar":"","name":"五华县"},{"code":441426,"firstChar":"","name":"平远县"},{"code":441427,"firstChar":"","name":"蕉岭县"},{"code":441481,"firstChar":"","name":"兴宁市"}]},{"code":101280500,"firstChar":"s","name":"汕头","subLevelModelList":[{"code":440507,"firstChar":"","name":"龙湖区"},{"code":440511,"firstChar":"","name":"金平区"},{"code":440512,"firstChar":"","name":"濠江区"},{"code":440513,"firstChar":"","name":"潮阳区"},{"code":440514,"firstChar":"","name":"潮南区"},{"code":440515,"firstChar":"","name":"澄海区"},{"code":440523,"firstChar":"","name":"南澳县"}]},{"code":101280600,"firstChar":"s","name":"深圳","subLevelModelList":[{"code":440303,"firstChar":"","name":"罗湖区"},{"code":440304,"firstChar":"","name":"福田区"},{"code":440305,"firstChar":"","name":"南山区"},{"code":440306,"firstChar":"","name":"宝安区"},{"code":440307,"firstChar":"","name":"龙岗区"},{"code":440308,"firstChar":"","name":"盐田区"}]},{"code":101280700,"firstChar":"z","name":"珠海","subLevelModelList":[{"code":440402,"firstChar":"","name":"香洲区"},{"code":440403,"firstChar":"","name":"斗门区"},{"code":440404,"firstChar":"","name":"金湾区"}]},{"code":101280800,"firstChar":"f","name":"佛山","subLevelModelList":[{"code":440604,"firstChar":"","name":"禅城区"},{"code":440605,"firstChar":"","name":"南海区"},{"code":440606,"firstChar":"","name":"顺德区"},{"code":440607,"firstChar":"","name":"三水区"},{"code":440608,"firstChar":"","name":"高明区"}]},{"code":101280900,"firstChar":"z","name":"肇庆","subLevelModelList":[{"code":441202,"firstChar":"","name":"端州区"},{"code":441203,"firstChar":"","name":"鼎湖区"},{"code":441223,"firstChar":"","name":"广宁县"},{"code":441224,"firstChar":"","name":"怀集县"},{"code":441225,"firstChar":"","name":"封开县"},{"code":441226,"firstChar":"","name":"德庆县"},{"code":441204,"firstChar":"","name":"高要区"},{"code":441284,"firstChar":"","name":"四会市"}]},{"code":101281000,"firstChar":"z","name":"湛江","subLevelModelList":[{"code":440802,"firstChar":"","name":"赤坎区"},{"code":440803,"firstChar":"","name":"霞山区"},{"code":440804,"firstChar":"","name":"坡头区"},{"code":440811,"firstChar":"","name":"麻章区"},{"code":440823,"firstChar":"","name":"遂溪县"},{"code":440825,"firstChar":"","name":"徐闻县"},{"code":440881,"firstChar":"","name":"廉江市"},{"code":440882,"firstChar":"","name":"雷州市"},{"code":440883,"firstChar":"","name":"吴川市"}]},{"code":101281100,"firstChar":"j","name":"江门","subLevelModelList":[{"code":440703,"firstChar":"","name":"蓬江区"},{"code":440704,"firstChar":"","name":"江海区"},{"code":440705,"firstChar":"","name":"新会区"},{"code":440781,"firstChar":"","name":"台山市"},{"code":440783,"firstChar":"","name":"开平市"},{"code":440784,"firstChar":"","name":"鹤山市"},{"code":440785,"firstChar":"","name":"恩平市"}]},{"code":101281200,"firstChar":"h","name":"河源","subLevelModelList":[{"code":441602,"firstChar":"","name":"源城区"},{"code":441621,"firstChar":"","name":"紫金县"},{"code":441622,"firstChar":"","name":"龙川县"},{"code":441623,"firstChar":"","name":"连平县"},{"code":441624,"firstChar":"","name":"和平县"},{"code":441625,"firstChar":"","name":"东源县"}]},{"code":101281300,"firstChar":"q","name":"清远","subLevelModelList":[{"code":441802,"firstChar":"","name":"清城区"},{"code":441803,"firstChar":"","name":"清新区"},{"code":441821,"firstChar":"","name":"佛冈县"},{"code":441823,"firstChar":"","name":"阳山县"},{"code":441825,"firstChar":"","name":"连山壮族瑶族自治县"},{"code":441826,"firstChar":"","name":"连南瑶族自治县"},{"code":441881,"firstChar":"","name":"英德市"},{"code":441882,"firstChar":"","name":"连州市"}]},{"code":101281400,"firstChar":"y","name":"云浮","subLevelModelList":[{"code":445302,"firstChar":"","name":"云城区"},{"code":445303,"firstChar":"","name":"云安区"},{"code":445321,"firstChar":"","name":"新兴县"},{"code":445322,"firstChar":"","name":"郁南县"},{"code":445381,"firstChar":"","name":"罗定市"}]},{"code":101281500,"firstChar":"c","name":"潮州","subLevelModelList":[{"code":445102,"firstChar":"","name":"湘桥区"},{"code":445103,"firstChar":"","name":"潮安区"},{"code":445122,"firstChar":"","name":"饶平县"}]},{"code":101281600,"firstChar":"d","name":"东莞","subLevelModelList":[{"code":441900,"firstChar":"","name":"东宝路"}]},{"code":101281700,"firstChar":"z","name":"中山","subLevelModelList":[{"code":442000,"firstChar":"","name":"竹苑"}]},{"code":101281800,"firstChar":"y","name":"阳江","subLevelModelList":[{"code":441702,"firstChar":"","name":"江城区"},{"code":441704,"firstChar":"","name":"阳东区"},{"code":441721,"firstChar":"","name":"阳西县"},{"code":441781,"firstChar":"","name":"阳春市"}]},{"code":101281900,"firstChar":"j","name":"揭阳","subLevelModelList":[{"code":445202,"firstChar":"","name":"榕城区"},{"code":445203,"firstChar":"","name":"揭东区"},{"code":445222,"firstChar":"","name":"揭西县"},{"code":445224,"firstChar":"","name":"惠来县"},{"code":445281,"firstChar":"","name":"普宁市"}]},{"code":101282000,"firstChar":"m","name":"茂名","subLevelModelList":[{"code":440902,"firstChar":"","name":"茂南区"},{"code":440904,"firstChar":"","name":"电白区"},{"code":440981,"firstChar":"","name":"高州市"},{"code":440982,"firstChar":"","name":"化州市"},{"code":440983,"firstChar":"","name":"信宜市"}]},{"code":101282100,"firstChar":"s","name":"汕尾","subLevelModelList":[{"code":441502,"firstChar":"","name":"城区"},{"code":441521,"firstChar":"","name":"海丰县"},{"code":441523,"firstChar":"","name":"陆河县"},{"code":441581,"firstChar":"","name":"陆丰市"}]}]},{"code":101290000,"firstChar":"y","name":"云南","subLevelModelList":[{"code":101290100,"firstChar":"k","name":"昆明","subLevelModelList":[{"code":530102,"firstChar":"","name":"五华区"},{"code":530103,"firstChar":"","name":"盘龙区"},{"code":530111,"firstChar":"","name":"官渡区"},{"code":530112,"firstChar":"","name":"西山区"},{"code":530113,"firstChar":"","name":"东川区"},{"code":530114,"firstChar":"","name":"呈贡区"},{"code":530122,"firstChar":"","name":"晋宁县"},{"code":530124,"firstChar":"","name":"富民县"},{"code":530125,"firstChar":"","name":"宜良县"},{"code":530126,"firstChar":"","name":"石林彝族自治县"},{"code":530127,"firstChar":"","name":"嵩明县"},{"code":530128,"firstChar":"","name":"禄劝彝族苗族自治县"},{"code":530129,"firstChar":"","name":"寻甸回族彝族自治县"},{"code":530181,"firstChar":"","name":"安宁市"}]},{"code":101290200,"firstChar":"q","name":"曲靖","subLevelModelList":[{"code":530302,"firstChar":"","name":"麒麟区"},{"code":530321,"firstChar":"","name":"马龙县"},{"code":530322,"firstChar":"","name":"陆良县"},{"code":530323,"firstChar":"","name":"师宗县"},{"code":530324,"firstChar":"","name":"罗平县"},{"code":530325,"firstChar":"","name":"富源县"},{"code":530326,"firstChar":"","name":"会泽县"},{"code":530303,"firstChar":"","name":"沾益区"},{"code":530381,"firstChar":"","name":"宣威市"}]},{"code":101290300,"firstChar":"b","name":"保山","subLevelModelList":[{"code":530502,"firstChar":"","name":"隆阳区"},{"code":530521,"firstChar":"","name":"施甸县"},{"code":530581,"firstChar":"","name":"腾冲市"},{"code":530523,"firstChar":"","name":"龙陵县"},{"code":530524,"firstChar":"","name":"昌宁县"}]},{"code":101290400,"firstChar":"y","name":"玉溪","subLevelModelList":[{"code":530402,"firstChar":"","name":"红塔区"},{"code":530403,"firstChar":"","name":"江川区"},{"code":530422,"firstChar":"","name":"澄江县"},{"code":530423,"firstChar":"","name":"通海县"},{"code":530424,"firstChar":"","name":"华宁县"},{"code":530425,"firstChar":"","name":"易门县"},{"code":530426,"firstChar":"","name":"峨山彝族自治县"},{"code":530427,"firstChar":"","name":"新平彝族傣族自治县"},{"code":530428,"firstChar":"","name":"元江哈尼族彝族傣族自治县"}]},{"code":101290500,"firstChar":"p","name":"普洱","subLevelModelList":[{"code":530802,"firstChar":"","name":"思茅区"},{"code":530821,"firstChar":"","name":"宁洱哈尼族彝族自治县"},{"code":530822,"firstChar":"","name":"墨江哈尼族自治县"},{"code":530823,"firstChar":"","name":"景东彝族自治县"},{"code":530824,"firstChar":"","name":"景谷傣族彝族自治县"},{"code":530825,"firstChar":"","name":"镇沅彝族哈尼族拉祜族自治县"},{"code":530826,"firstChar":"","name":"江城哈尼族彝族自治县"},{"code":530827,"firstChar":"","name":"孟连傣族拉祜族佤族自治县"},{"code":530828,"firstChar":"","name":"澜沧拉祜族自治县"},{"code":530829,"firstChar":"","name":"西盟佤族自治县"}]},{"code":101290700,"firstChar":"z","name":"昭通","subLevelModelList":[{"code":530602,"firstChar":"","name":"昭阳区"},{"code":530621,"firstChar":"","name":"鲁甸县"},{"code":530622,"firstChar":"","name":"巧家县"},{"code":530623,"firstChar":"","name":"盐津县"},{"code":530624,"firstChar":"","name":"大关县"},{"code":530625,"firstChar":"","name":"永善县"},{"code":530626,"firstChar":"","name":"绥江县"},{"code":530627,"firstChar":"","name":"镇雄县"},{"code":530628,"firstChar":"","name":"彝良县"},{"code":530629,"firstChar":"","name":"威信县"},{"code":530630,"firstChar":"","name":"水富县"}]},{"code":101290800,"firstChar":"l","name":"临沧","subLevelModelList":[{"code":530902,"firstChar":"","name":"临翔区"},{"code":530921,"firstChar":"","name":"凤庆县"},{"code":530922,"firstChar":"","name":"云县"},{"code":530923,"firstChar":"","name":"永德县"},{"code":530924,"firstChar":"","name":"镇康县"},{"code":530925,"firstChar":"","name":"双江拉祜族佤族布朗族傣族自治县"},{"code":530926,"firstChar":"","name":"耿马傣族佤族自治县"},{"code":530927,"firstChar":"","name":"沧源佤族自治县"}]},{"code":101290900,"firstChar":"l","name":"丽江","subLevelModelList":[{"code":530702,"firstChar":"","name":"古城区"},{"code":530721,"firstChar":"","name":"玉龙纳西族自治县"},{"code":530722,"firstChar":"","name":"永胜县"},{"code":530723,"firstChar":"","name":"华坪县"},{"code":530724,"firstChar":"","name":"宁蒗彝族自治县"}]},{"code":101291000,"firstChar":"x","name":"西双版纳","subLevelModelList":[{"code":532801,"firstChar":"","name":"景洪市"},{"code":532822,"firstChar":"","name":"勐海县"},{"code":532823,"firstChar":"","name":"勐腊县"}]},{"code":101291100,"firstChar":"w","name":"文山","subLevelModelList":[{"code":532622,"firstChar":"","name":"砚山县"},{"code":532623,"firstChar":"","name":"西畴县"},{"code":532624,"firstChar":"","name":"麻栗坡县"},{"code":532625,"firstChar":"","name":"马关县"},{"code":532626,"firstChar":"","name":"丘北县"},{"code":532627,"firstChar":"","name":"广南县"},{"code":532628,"firstChar":"","name":"富宁县"}]},{"code":101291200,"firstChar":"h","name":"红河","subLevelModelList":[{"code":532501,"firstChar":"","name":"个旧市"},{"code":532502,"firstChar":"","name":"开远市"},{"code":532503,"firstChar":"","name":"蒙自市"},{"code":532504,"firstChar":"","name":"弥勒市"},{"code":532523,"firstChar":"","name":"屏边苗族自治县"},{"code":532524,"firstChar":"","name":"建水县"},{"code":532525,"firstChar":"","name":"石屏县"},{"code":532527,"firstChar":"","name":"泸西县"},{"code":532528,"firstChar":"","name":"元阳县"},{"code":532530,"firstChar":"","name":"金平苗族瑶族傣族自治县"},{"code":532531,"firstChar":"","name":"绿春县"},{"code":532532,"firstChar":"","name":"河口瑶族自治县"}]},{"code":101291300,"firstChar":"d","name":"德宏","subLevelModelList":[{"code":533102,"firstChar":"","name":"瑞丽市"},{"code":533103,"firstChar":"","name":"芒市"},{"code":533122,"firstChar":"","name":"梁河县"},{"code":533123,"firstChar":"","name":"盈江县"},{"code":533124,"firstChar":"","name":"陇川县"}]},{"code":101291400,"firstChar":"n","name":"怒江","subLevelModelList":[{"code":533321,"firstChar":"","name":"泸水市"},{"code":533323,"firstChar":"","name":"福贡县"},{"code":533324,"firstChar":"","name":"贡山独龙族怒族自治县"},{"code":533325,"firstChar":"","name":"兰坪白族普米族自治县"}]},{"code":101291500,"firstChar":"d","name":"迪庆","subLevelModelList":[{"code":533401,"firstChar":"","name":"香格里拉市"},{"code":533422,"firstChar":"","name":"德钦县"},{"code":533423,"firstChar":"","name":"维西傈僳族自治县"}]},{"code":101291600,"firstChar":"d","name":"大理","subLevelModelList":[{"code":532922,"firstChar":"","name":"漾濞彝族自治县"},{"code":532923,"firstChar":"","name":"祥云县"},{"code":532924,"firstChar":"","name":"宾川县"},{"code":532925,"firstChar":"","name":"弥渡县"},{"code":532926,"firstChar":"","name":"南涧彝族自治县"},{"code":532927,"firstChar":"","name":"巍山彝族回族自治县"},{"code":532928,"firstChar":"","name":"永平县"},{"code":532929,"firstChar":"","name":"云龙县"},{"code":532930,"firstChar":"","name":"洱源县"},{"code":532931,"firstChar":"","name":"剑川县"},{"code":532932,"firstChar":"","name":"鹤庆县"}]},{"code":101291700,"firstChar":"c","name":"楚雄","subLevelModelList":[{"code":532322,"firstChar":"","name":"双柏县"},{"code":532323,"firstChar":"","name":"牟定县"},{"code":532324,"firstChar":"","name":"南华县"},{"code":532325,"firstChar":"","name":"姚安县"},{"code":532326,"firstChar":"","name":"大姚县"},{"code":532327,"firstChar":"","name":"永仁县"},{"code":532328,"firstChar":"","name":"元谋县"},{"code":532329,"firstChar":"","name":"武定县"},{"code":532331,"firstChar":"","name":"禄丰县"}]}]},{"code":101300000,"firstChar":"g","name":"广西","subLevelModelList":[{"code":101300100,"firstChar":"n","name":"南宁","subLevelModelList":[{"code":450102,"firstChar":"","name":"兴宁区"},{"code":450103,"firstChar":"","name":"青秀区"},{"code":450105,"firstChar":"","name":"江南区"},{"code":450107,"firstChar":"","name":"西乡塘区"},{"code":450108,"firstChar":"","name":"良庆区"},{"code":450109,"firstChar":"","name":"邕宁区"},{"code":450110,"firstChar":"","name":"武鸣区"},{"code":450123,"firstChar":"","name":"隆安县"},{"code":450124,"firstChar":"","name":"马山县"},{"code":450125,"firstChar":"","name":"上林县"},{"code":450126,"firstChar":"","name":"宾阳县"},{"code":450127,"firstChar":"","name":"横县"}]},{"code":101300200,"firstChar":"c","name":"崇左","subLevelModelList":[{"code":451402,"firstChar":"","name":"江州区"},{"code":451421,"firstChar":"","name":"扶绥县"},{"code":451422,"firstChar":"","name":"宁明县"},{"code":451423,"firstChar":"","name":"龙州县"},{"code":451424,"firstChar":"","name":"大新县"},{"code":451425,"firstChar":"","name":"天等县"},{"code":451481,"firstChar":"","name":"凭祥市"}]},{"code":101300300,"firstChar":"l","name":"柳州","subLevelModelList":[{"code":450202,"firstChar":"","name":"城中区"},{"code":450203,"firstChar":"","name":"鱼峰区"},{"code":450204,"firstChar":"","name":"柳南区"},{"code":450205,"firstChar":"","name":"柳北区"},{"code":450221,"firstChar":"","name":"柳江区"},{"code":450222,"firstChar":"","name":"柳城县"},{"code":450223,"firstChar":"","name":"鹿寨县"},{"code":450224,"firstChar":"","name":"融安县"},{"code":450225,"firstChar":"","name":"融水苗族自治县"},{"code":450226,"firstChar":"","name":"三江侗族自治县"}]},{"code":101300400,"firstChar":"l","name":"来宾","subLevelModelList":[{"code":451302,"firstChar":"","name":"兴宾区"},{"code":451321,"firstChar":"","name":"忻城县"},{"code":451322,"firstChar":"","name":"象州县"},{"code":451323,"firstChar":"","name":"武宣县"},{"code":451324,"firstChar":"","name":"金秀瑶族自治县"},{"code":451381,"firstChar":"","name":"合山市"}]},{"code":101300500,"firstChar":"g","name":"桂林","subLevelModelList":[{"code":450302,"firstChar":"","name":"秀峰区"},{"code":450303,"firstChar":"","name":"叠彩区"},{"code":450304,"firstChar":"","name":"象山区"},{"code":450305,"firstChar":"","name":"七星区"},{"code":450311,"firstChar":"","name":"雁山区"},{"code":450312,"firstChar":"","name":"临桂区"},{"code":450321,"firstChar":"","name":"阳朔县"},{"code":450323,"firstChar":"","name":"灵川县"},{"code":450324,"firstChar":"","name":"全州县"},{"code":450325,"firstChar":"","name":"兴安县"},{"code":450326,"firstChar":"","name":"永福县"},{"code":450327,"firstChar":"","name":"灌阳县"},{"code":450328,"firstChar":"","name":"龙胜各族自治县"},{"code":450329,"firstChar":"","name":"资源县"},{"code":450330,"firstChar":"","name":"平乐县"},{"code":450331,"firstChar":"","name":"荔浦县"},{"code":450332,"firstChar":"","name":"恭城瑶族自治县"}]},{"code":101300600,"firstChar":"w","name":"梧州","subLevelModelList":[{"code":450403,"firstChar":"","name":"万秀区"},{"code":450405,"firstChar":"","name":"长洲区"},{"code":450406,"firstChar":"","name":"龙圩区"},{"code":450421,"firstChar":"","name":"苍梧县"},{"code":450422,"firstChar":"","name":"藤县"},{"code":450423,"firstChar":"","name":"蒙山县"},{"code":450481,"firstChar":"","name":"岑溪市"}]},{"code":101300700,"firstChar":"h","name":"贺州","subLevelModelList":[{"code":451102,"firstChar":"","name":"八步区"},{"code":451121,"firstChar":"","name":"昭平县"},{"code":451122,"firstChar":"","name":"钟山县"},{"code":451123,"firstChar":"","name":"富川瑶族自治县"}]},{"code":101300800,"firstChar":"g","name":"贵港","subLevelModelList":[{"code":450802,"firstChar":"","name":"港北区"},{"code":450803,"firstChar":"","name":"港南区"},{"code":450804,"firstChar":"","name":"覃塘区"},{"code":450821,"firstChar":"","name":"平南县"},{"code":450881,"firstChar":"","name":"桂平市"}]},{"code":101300900,"firstChar":"y","name":"玉林","subLevelModelList":[{"code":450902,"firstChar":"","name":"玉州区"},{"code":450903,"firstChar":"","name":"福绵区"},{"code":450921,"firstChar":"","name":"容县"},{"code":450922,"firstChar":"","name":"陆川县"},{"code":450923,"firstChar":"","name":"博白县"},{"code":450924,"firstChar":"","name":"兴业县"},{"code":450981,"firstChar":"","name":"北流市"}]},{"code":101301000,"firstChar":"b","name":"百色","subLevelModelList":[{"code":451002,"firstChar":"","name":"右江区"},{"code":451021,"firstChar":"","name":"田阳县"},{"code":451022,"firstChar":"","name":"田东县"},{"code":451023,"firstChar":"","name":"平果县"},{"code":451024,"firstChar":"","name":"德保县"},{"code":451081,"firstChar":"","name":"靖西市"},{"code":451026,"firstChar":"","name":"那坡县"},{"code":451027,"firstChar":"","name":"凌云县"},{"code":451028,"firstChar":"","name":"乐业县"},{"code":451029,"firstChar":"","name":"田林县"},{"code":451030,"firstChar":"","name":"西林县"},{"code":451031,"firstChar":"","name":"隆林各族自治县"}]},{"code":101301100,"firstChar":"q","name":"钦州","subLevelModelList":[{"code":450702,"firstChar":"","name":"钦南区"},{"code":450703,"firstChar":"","name":"钦北区"},{"code":450721,"firstChar":"","name":"灵山县"},{"code":450722,"firstChar":"","name":"浦北县"}]},{"code":101301200,"firstChar":"h","name":"河池","subLevelModelList":[{"code":451202,"firstChar":"","name":"金城江区"},{"code":451221,"firstChar":"","name":"南丹县"},{"code":451222,"firstChar":"","name":"天峨县"},{"code":451223,"firstChar":"","name":"凤山县"},{"code":451224,"firstChar":"","name":"东兰县"},{"code":451225,"firstChar":"","name":"罗城仫佬族自治县"},{"code":451226,"firstChar":"","name":"环江毛南族自治县"},{"code":451227,"firstChar":"","name":"巴马瑶族自治县"},{"code":451228,"firstChar":"","name":"都安瑶族自治县"},{"code":451229,"firstChar":"","name":"大化瑶族自治县"},{"code":451281,"firstChar":"","name":"宜州市"}]},{"code":101301300,"firstChar":"b","name":"北海","subLevelModelList":[{"code":450502,"firstChar":"","name":"海城区"},{"code":450503,"firstChar":"","name":"银海区"},{"code":450512,"firstChar":"","name":"铁山港区"},{"code":450521,"firstChar":"","name":"合浦县"}]},{"code":101301400,"firstChar":"f","name":"防城港","subLevelModelList":[{"code":450602,"firstChar":"","name":"港口区"},{"code":450603,"firstChar":"","name":"防城区"},{"code":450621,"firstChar":"","name":"上思县"},{"code":450681,"firstChar":"","name":"东兴市"}]}]},{"code":101310000,"firstChar":"h","name":"海南","subLevelModelList":[{"code":101310100,"firstChar":"h","name":"海口","subLevelModelList":[{"code":460105,"firstChar":"","name":"秀英区"},{"code":460106,"firstChar":"","name":"龙华区"},{"code":460107,"firstChar":"","name":"琼山区"},{"code":460108,"firstChar":"","name":"美兰区"}]},{"code":101310200,"firstChar":"s","name":"三亚","subLevelModelList":[{"code":460202,"firstChar":"","name":"海棠区"},{"code":460203,"firstChar":"","name":"吉阳区"},{"code":460204,"firstChar":"","name":"天涯区"},{"code":460205,"firstChar":"","name":"崖州区"}]},{"code":101310300,"firstChar":"s","name":"三沙","subLevelModelList":[{"code":460321,"firstChar":"","name":"西沙群岛"},{"code":460322,"firstChar":"","name":"南沙群岛"},{"code":460323,"firstChar":"","name":"中沙群岛的岛礁及其海域"}]}]},{"code":101340000,"firstChar":"t","name":"台湾","subLevelModelList":[{"code":101340100,"firstChar":"t","name":"台北"},{"code":101340200,"firstChar":"x","name":"新北"},{"code":101340300,"firstChar":"t","name":"台中"},{"code":101340400,"firstChar":"t","name":"台南"},{"code":101340500,"firstChar":"g","name":"高雄"},{"code":101340600,"firstChar":"j","name":"基隆"},{"code":101340700,"firstChar":"j","name":"嘉义"},{"code":101340800,"firstChar":"p","name":"屏东"}]},{"code":101140000,"firstChar":"x","name":"西藏","subLevelModelList":[{"code":101140100,"firstChar":"l","name":"拉萨","subLevelModelList":[{"code":540102,"firstChar":"","name":"城关区"},{"code":540121,"firstChar":"","name":"林周县"},{"code":540122,"firstChar":"","name":"当雄县"},{"code":540123,"firstChar":"","name":"尼木县"},{"code":540124,"firstChar":"","name":"曲水县"},{"code":540103,"firstChar":"","name":"堆龙德庆区"},{"code":540126,"firstChar":"","name":"达孜县"},{"code":540127,"firstChar":"","name":"墨竹工卡县"}]}]},{"code":101320000,"firstChar":"x","name":"香港","subLevelModelList":[{"code":101320300,"firstChar":"x","name":"香港","subLevelModelList":[{"code":810001,"firstChar":"","name":"中西区"},{"code":810002,"firstChar":"","name":"湾仔区"},{"code":810003,"firstChar":"","name":"东区"},{"code":810004,"firstChar":"","name":"南区"},{"code":810005,"firstChar":"","name":"油尖旺区"},{"code":810006,"firstChar":"","name":"深水埗区"},{"code":810007,"firstChar":"","name":"九龙城区"},{"code":810008,"firstChar":"","name":"黄大仙区"},{"code":810009,"firstChar":"","name":"观塘区"},{"code":810010,"firstChar":"","name":"荃湾区"},{"code":810011,"firstChar":"","name":"屯门区"},{"code":810012,"firstChar":"","name":"元朗区"},{"code":810013,"firstChar":"","name":"北区"},{"code":810014,"firstChar":"","name":"大埔区"},{"code":810015,"firstChar":"","name":"西贡区"},{"code":810016,"firstChar":"","name":"沙田区"},{"code":810017,"firstChar":"","name":"葵青区"},{"code":810018,"firstChar":"","name":"离岛区"}]}]},{"code":101330000,"firstChar":"a","name":"澳门","subLevelModelList":[{"code":101330100,"firstChar":"a","name":"澳门","subLevelModelList":[{"code":820001,"firstChar":"","name":"花地玛堂区"},{"code":820002,"firstChar":"","name":"花王堂区"},{"code":820003,"firstChar":"","name":"望德堂区"},{"code":820004,"firstChar":"","name":"大堂区"},{"code":820005,"firstChar":"","name":"风顺堂区"},{"code":820006,"firstChar":"","name":"嘉模堂区"},{"code":820007,"firstChar":"","name":"路凼填海区"},{"code":820008,"firstChar":"","name":"圣方济各堂区"}]}]}]
     * dataVersion : 6.8
     * degree : [{"code":201,"name":"不限"},{"code":207,"name":"中专及以下"},{"code":206,"name":"高中"},{"code":202,"name":"大专"},{"code":203,"name":"本科"},{"code":204,"name":"硕士"},{"code":205,"name":"博士"}]
     * experience : [{"code":101,"name":"不限"},{"code":102,"name":"应届生"},{"code":103,"name":"1年以内"},{"code":104,"name":"1-3年"},{"code":105,"name":"3-5年"},{"code":106,"name":"5-10年"},{"code":107,"name":"10年以上"}]
     * geekFilterConfig : [{"code":400,"name":"薪水","paramName":"salary","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":402,"name":"3k以下"},{"code":403,"name":"3k-5k"},{"code":404,"name":"5k-10k"},{"code":405,"name":"10k-20k"},{"code":406,"name":"20k-50k"},{"code":407,"name":"50k以上"}]},{"code":100,"name":"经验","paramName":"experience","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":102,"name":"应届生"},{"code":103,"name":"1年以内"},{"code":104,"name":"1-3年"},{"code":105,"name":"3-5年"},{"code":106,"name":"5-10年"},{"code":107,"name":"10年以上"}]},{"code":300,"name":"人员规模","paramName":"scale","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":301,"name":"0-20人"},{"code":302,"name":"20-99人"},{"code":303,"name":"100-499人"},{"code":304,"name":"500-999人"},{"code":305,"name":"1000-9999人"},{"code":306,"name":"10000人以上"}]},{"code":200,"name":"学历","paramName":"degree","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":207,"name":"中专及以下"},{"code":206,"name":"高中"},{"code":202,"name":"大专"},{"code":203,"name":"本科"},{"code":204,"name":"硕士"},{"code":205,"name":"博士"}]},{"code":800,"name":"融资阶段","paramName":"stage","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":801,"name":"未融资"},{"code":802,"name":"天使轮"},{"code":803,"name":"A轮"},{"code":804,"name":"B轮"},{"code":805,"name":"C轮"},{"code":806,"name":"D轮及以上"},{"code":807,"name":"已上市"},{"code":808,"name":"不需要融资"}]},{"code":500,"name":"行业","paramName":"industry","subFilterConfigModel":[{"code":0,"name":"全部"},{"code":501,"name":"非互联网行业"},{"code":502,"name":"健康医疗"},{"code":503,"name":"生活服务"},{"code":504,"name":"旅游"},{"code":505,"name":"金融"},{"code":506,"name":"信息安全"},{"code":507,"name":"广告营销"},{"code":508,"name":"数据服务"},{"code":509,"name":"智能硬件"},{"code":510,"name":"文化娱乐"},{"code":511,"name":"网络招聘"},{"code":512,"name":"分类信息"},{"code":513,"name":"电子商务"},{"code":514,"name":"移动互联网"},{"code":515,"name":"企业服务"},{"code":516,"name":"社交网络"},{"code":517,"name":"教育培训"},{"code":518,"name":"O2O"},{"code":519,"name":"游戏"},{"code":520,"name":"互联网"},{"code":521,"name":"媒体"},{"code":522,"name":"IT软件"}]}]
     * hotCity : [{"code":0,"name":"全国"},{"code":101010100,"name":"北京"},{"code":101020100,"name":"上海"},{"code":101210100,"name":"杭州"},{"code":101280600,"name":"深圳"},{"code":101280100,"name":"广州"},{"code":101270100,"name":"成都"},{"code":101190100,"name":"南京"},{"code":101200100,"name":"武汉"},{"code":101030100,"name":"天津"},{"code":101110100,"name":"西安"},{"code":101190400,"name":"苏州"}]
     * industry : [{"code":502,"name":"健康医疗"},{"code":503,"name":"生活服务"},{"code":504,"name":"旅游"},{"code":505,"name":"金融"},{"code":506,"name":"信息安全"},{"code":507,"name":"广告营销"},{"code":508,"name":"数据服务"},{"code":509,"name":"智能硬件"},{"code":510,"name":"文化娱乐"},{"code":511,"name":"网络招聘"},{"code":512,"name":"分类信息"},{"code":513,"name":"电子商务"},{"code":514,"name":"移动互联网"},{"code":515,"name":"企业服务"},{"code":516,"name":"社交网络"},{"code":517,"name":"教育培训"},{"code":518,"name":"O2O"},{"code":519,"name":"游戏"},{"code":520,"name":"互联网"},{"code":521,"name":"媒体"},{"code":522,"name":"IT软件"},{"code":523,"name":"通信"},{"code":524,"name":"公关会展"},{"code":525,"name":"房地产/建筑"},{"code":526,"name":"汽车"},{"code":527,"name":"供应链/物流"},{"code":528,"name":"咨询/翻译/法律"},{"code":529,"name":"采购/贸易"},{"code":501,"name":"非互联网行业"}]
     * industryHeader : [{"code":100100,"name":"互联网"}]
     * position : [{"code":100000,"name":"技术","subLevelModelList":[{"code":100100,"name":"后端开发","subLevelModelList":[{"code":100101,"name":"Java"},{"code":100102,"name":"C++"},{"code":100103,"name":"PHP"},{"code":100104,"name":"数据挖掘"},{"code":100105,"name":"C"},{"code":100106,"name":"C#"},{"code":100107,"name":".NET"},{"code":100108,"name":"Hadoop"},{"code":100109,"name":"Python"},{"code":100110,"name":"Delphi"},{"code":100111,"name":"VB"},{"code":100112,"name":"Perl"},{"code":100113,"name":"Ruby"},{"code":100114,"name":"Node.js"},{"code":100115,"name":"搜索算法"},{"code":100116,"name":"Golang"},{"code":100117,"name":"自然语言处理"},{"code":100118,"name":"推荐算法"},{"code":100119,"name":"Erlang"},{"code":100120,"name":"算法工程师"},{"code":100121,"name":"语音/视频/图形开发"},{"code":100122,"name":"数据采集"}]},{"code":100200,"name":"移动开发","subLevelModelList":[{"code":100201,"name":"HTML5"},{"code":100202,"name":"Android"},{"code":100203,"name":"iOS"},{"code":100204,"name":"WP"},{"code":100205,"name":"Web前端"},{"code":100206,"name":"Flash"},{"code":100208,"name":"JavaScript"},{"code":100209,"name":"U3D"},{"code":100210,"name":"COCOS2DX"}]},{"code":100300,"name":"测试","subLevelModelList":[{"code":100301,"name":"测试工程师"},{"code":100302,"name":"自动化测试"},{"code":100303,"name":"功能测试"},{"code":100304,"name":"性能测试"},{"code":100305,"name":"测试开发"},{"code":100306,"name":"移动端测试"},{"code":100307,"name":"游戏测试"},{"code":100308,"name":"硬件测试"},{"code":100309,"name":"软件测试"}]},{"code":100400,"name":"运维/技术支持","subLevelModelList":[{"code":100401,"name":"运维工程师"},{"code":100402,"name":"运维开发工程师"},{"code":100403,"name":"网络工程师"},{"code":100404,"name":"系统工程师"},{"code":100405,"name":"IT技术支持"},{"code":100406,"name":"系统管理员"},{"code":100407,"name":"网络安全"},{"code":100408,"name":"系统安全"},{"code":100409,"name":"DBA"}]},{"code":100500,"name":"数据","subLevelModelList":[{"code":100506,"name":"ETL工程师"},{"code":100507,"name":"数据仓库"},{"code":100508,"name":"数据开发"},{"code":100509,"name":"数据挖掘"},{"code":100510,"name":"数据处理工程师"},{"code":100511,"name":"数据分析师"},{"code":100512,"name":"数据架构师"}]},{"code":100600,"name":"项目管理","subLevelModelList":[{"code":100601,"name":"项目经理"},{"code":100602,"name":"项目主管"},{"code":100603,"name":"项目助理"},{"code":100604,"name":"项目专员"},{"code":100605,"name":"实施顾问"},{"code":100606,"name":"实施工程师"},{"code":100607,"name":"需求分析工程师"}]},{"code":100800,"name":"硬件开发","subLevelModelList":[{"code":100801,"name":"硬件"},{"code":100802,"name":"嵌入式"},{"code":100803,"name":"自动化"},{"code":100804,"name":"单片机"},{"code":100805,"name":"电路设计"},{"code":100806,"name":"驱动开发"},{"code":100807,"name":"系统集成"},{"code":100808,"name":"FPGA开发"},{"code":100809,"name":"DSP开发"},{"code":100810,"name":"ARM开发"},{"code":100811,"name":"PCB工艺"},{"code":100812,"name":"模具设计"},{"code":100813,"name":"热传导"},{"code":100814,"name":"材料工程师"},{"code":100815,"name":"精益工程师"},{"code":100816,"name":"射频工程师"}]},{"code":100900,"name":"前端开发","subLevelModelList":[{"code":100901,"name":"web前端"},{"code":100902,"name":"Javascript"},{"code":100903,"name":"Flash"},{"code":100904,"name":"HTML5"}]},{"code":101000,"name":"通信","subLevelModelList":[{"code":101001,"name":"通信技术工程师"},{"code":101002,"name":"通信研发工程师"},{"code":101003,"name":"数据通信工程师"},{"code":101004,"name":"移动通信工程师"},{"code":101005,"name":"电信网络工程师"},{"code":101006,"name":"电信交换工程师"},{"code":101007,"name":"有线传输工程师"},{"code":101008,"name":"无线射频工程师"},{"code":101009,"name":"通信电源工程师"},{"code":101010,"name":"通信标准化工程师"},{"code":101011,"name":"通信项目专员"},{"code":101012,"name":"通信项目经理"},{"code":101013,"name":"核心网工程师"},{"code":101014,"name":"通信测试工程师"},{"code":101015,"name":"通信设备工程师"},{"code":101016,"name":"光通信工程师"},{"code":101017,"name":"光传输工程师"},{"code":101018,"name":"光网络工程师"}]},{"code":100700,"name":"高端技术职位","subLevelModelList":[{"code":100701,"name":"技术经理"},{"code":100702,"name":"技术总监"},{"code":100703,"name":"测试经理"},{"code":100704,"name":"架构师"},{"code":100705,"name":"CTO"},{"code":100706,"name":"运维总监"},{"code":100707,"name":"技术合伙人"}]},{"code":101300,"name":"人工智能","subLevelModelList":[{"code":101301,"name":"机器学习"},{"code":101302,"name":"深度学习"},{"code":101303,"name":"图像算法"},{"code":101304,"name":"图像处理"},{"code":101305,"name":"语音识别"},{"code":101306,"name":"图像识别"}]},{"code":101200,"name":"软件销售支持","subLevelModelList":[{"code":101201,"name":"售前工程师"},{"code":101202,"name":"售后工程师"}]},{"code":101100,"name":"其他技术职位","subLevelModelList":[{"code":101101,"name":"其他技术职位"}]}]},{"code":110000,"name":"产品","subLevelModelList":[{"code":110100,"name":"产品经理","subLevelModelList":[{"code":110101,"name":"产品经理"},{"code":110102,"name":"网页产品经理"},{"code":110103,"name":"移动产品经理"},{"code":110104,"name":"产品助理"},{"code":110105,"name":"数据产品经理"},{"code":110106,"name":"电商产品经理"},{"code":110107,"name":"游戏策划"}]},{"code":110200,"name":"产品设计师","subLevelModelList":[{"code":110201,"name":"网页产品设计师"},{"code":110202,"name":"无线产品设计师"}]},{"code":110300,"name":"高端产品职位","subLevelModelList":[{"code":110301,"name":"产品部经理"},{"code":110302,"name":"产品总监"},{"code":110303,"name":"游戏制作人"},{"code":110304,"name":"产品VP"}]},{"code":110400,"name":"其他产品职位","subLevelModelList":[{"code":110401,"name":"其他产品职位"}]}]},{"code":120000,"name":"设计","subLevelModelList":[{"code":120100,"name":"视觉设计","subLevelModelList":[{"code":120101,"name":"视觉设计师"},{"code":120102,"name":"网页设计师"},{"code":120103,"name":"Flash设计师"},{"code":120104,"name":"APP设计师"},{"code":120105,"name":"UI设计师"},{"code":120106,"name":"平面设计师"},{"code":120107,"name":"美术设计师（2D/3D）"},{"code":120108,"name":"广告设计师"},{"code":120109,"name":"多媒体设计师"},{"code":120110,"name":"原画师"},{"code":120111,"name":"游戏特效"},{"code":120112,"name":"游戏界面设计师"},{"code":120113,"name":"游戏场景"},{"code":120114,"name":"游戏角色"},{"code":120115,"name":"游戏动作"},{"code":120116,"name":"三维/CAD/制图"},{"code":120117,"name":"美工"},{"code":120118,"name":"包装设计"},{"code":120119,"name":"设计师助理"},{"code":120120,"name":"动画设计师"}]},{"code":120200,"name":"交互设计","subLevelModelList":[{"code":120201,"name":"交互设计师"},{"code":120202,"name":"无线交互设计师"},{"code":120203,"name":"网页交互设计师"},{"code":120204,"name":"硬件交互设计师"}]},{"code":120300,"name":"用户研究","subLevelModelList":[{"code":120301,"name":"数据分析师"},{"code":120302,"name":"用户研究员"},{"code":120303,"name":"游戏数值策划"},{"code":120304,"name":"UX设计师"},{"code":120407,"name":"用户研究经理"},{"code":120408,"name":"用户研究总监"}]},{"code":120400,"name":"高端设计职位","subLevelModelList":[{"code":120401,"name":"设计经理/主管"},{"code":120402,"name":"设计总监"},{"code":120403,"name":"视觉设计经理"},{"code":120404,"name":"视觉设计总监"},{"code":120405,"name":"交互设计经理/主管"},{"code":120406,"name":"交互设计总监"}]},{"code":120600,"name":"非视觉设计","subLevelModelList":[{"code":120601,"name":"服装设计"},{"code":120602,"name":"工业设计"},{"code":120603,"name":"橱柜设计"},{"code":120604,"name":"家具设计"},{"code":120605,"name":"家居设计"},{"code":120606,"name":"珠宝设计"}]},{"code":120500,"name":"其他设计职位","subLevelModelList":[{"code":120501,"name":"其他设计职位"}]}]},{"code":130000,"name":"运营","subLevelModelList":[{"code":130100,"name":"运营","subLevelModelList":[{"code":130101,"name":"用户运营"},{"code":130102,"name":"产品运营"},{"code":130103,"name":"数据运营"},{"code":130104,"name":"内容运营"},{"code":130105,"name":"活动运营"},{"code":130106,"name":"商家运营"},{"code":130107,"name":"品类运营"},{"code":130108,"name":"游戏运营"},{"code":130109,"name":"网络推广"},{"code":130110,"name":"网站运营"},{"code":130111,"name":"新媒体运营"},{"code":130112,"name":"社区运营"},{"code":130113,"name":"微信运营"},{"code":130114,"name":"微博运营"},{"code":130115,"name":"策略运营"},{"code":130116,"name":"线下拓展运营"},{"code":130117,"name":"电商运营"},{"code":130118,"name":"运营助理/专员"},{"code":130119,"name":"销售运营"}]},{"code":130200,"name":"编辑","subLevelModelList":[{"code":130201,"name":"副主编"},{"code":130202,"name":"内容编辑"},{"code":130203,"name":"文案策划"},{"code":130204,"name":"网站编辑"},{"code":130205,"name":"记者"},{"code":130206,"name":"采编"}]},{"code":130300,"name":"客服","subLevelModelList":[{"code":130301,"name":"售前咨询"},{"code":130302,"name":"售后客服"},{"code":130303,"name":"淘宝客服"},{"code":130304,"name":"客服经理"},{"code":130305,"name":"客服专员"}]},{"code":130400,"name":"高端运营职位","subLevelModelList":[{"code":130401,"name":"主编"},{"code":130402,"name":"运营总监"},{"code":130403,"name":"COO"},{"code":130404,"name":"客服总监"},{"code":130405,"name":"运营经理/主管"}]},{"code":130500,"name":"其他运营职位","subLevelModelList":[{"code":130501,"name":"其他运营职位"}]}]},{"code":140000,"name":"市场","subLevelModelList":[{"code":140100,"name":"市场/营销","subLevelModelList":[{"code":140101,"name":"市场营销"},{"code":140102,"name":"市场策划"},{"code":140103,"name":"市场顾问"},{"code":140104,"name":"市场推广"},{"code":140105,"name":"SEO"},{"code":140106,"name":"SEM"},{"code":140107,"name":"商务渠道"},{"code":140108,"name":"商业数据分析"},{"code":140109,"name":"活动策划"},{"code":140110,"name":"网络营销"},{"code":140111,"name":"海外市场"},{"code":140112,"name":"政府关系"}]},{"code":140200,"name":"公关媒介","subLevelModelList":[{"code":140201,"name":"媒介经理"},{"code":140202,"name":"广告协调"},{"code":140203,"name":"品牌公关"},{"code":140204,"name":"媒介专员"},{"code":140205,"name":"活动策划执行"},{"code":140206,"name":"媒介策划"}]},{"code":140500,"name":"会务会展","subLevelModelList":[{"code":140501,"name":"会议活动销售"},{"code":140502,"name":"会议活动策划"},{"code":140503,"name":"会议活动执行"},{"code":140504,"name":"会展活动销售"},{"code":140505,"name":"会展活动策划"},{"code":140506,"name":"会展活动执行"}]},{"code":140600,"name":"广告","subLevelModelList":[{"code":140601,"name":"广告创意"},{"code":140602,"name":"美术指导"},{"code":140603,"name":"广告设计师"},{"code":140604,"name":"策划经理"},{"code":140605,"name":"文案"},{"code":140606,"name":"资深文案"},{"code":140607,"name":"广告制作"},{"code":140608,"name":"媒介投放"},{"code":140609,"name":"媒介合作"},{"code":140610,"name":"媒介顾问"},{"code":140611,"name":"广告审核"}]},{"code":140400,"name":"高端市场职位","subLevelModelList":[{"code":140401,"name":"市场总监"},{"code":140404,"name":"CMO"},{"code":140405,"name":"公关总监"},{"code":140406,"name":"媒介总监"},{"code":140407,"name":"创意总监"}]},{"code":140700,"name":"其他市场职位","subLevelModelList":[{"code":140701,"name":"其他市场职位"}]}]},{"code":150000,"name":"职能/高级管理","subLevelModelList":[{"code":150100,"name":"人力资源","subLevelModelList":[{"code":150101,"name":"人力资源"},{"code":150102,"name":"招聘"},{"code":150103,"name":"HRBP"},{"code":150104,"name":"人事/HR"},{"code":150105,"name":"培训经理"},{"code":150106,"name":"薪资福利经理"},{"code":150107,"name":"绩效考核经理"}]},{"code":150200,"name":"行政","subLevelModelList":[{"code":150201,"name":"助理/文员"},{"code":150202,"name":"前台"},{"code":150204,"name":"行政"},{"code":150205,"name":"总助"},{"code":150206,"name":"文秘"},{"code":150207,"name":"后勤"},{"code":150208,"name":"商务司机"}]},{"code":150300,"name":"财务","subLevelModelList":[{"code":150301,"name":"会计"},{"code":150302,"name":"出纳"},{"code":150303,"name":"财务"},{"code":150304,"name":"结算"},{"code":150305,"name":"税务"},{"code":150306,"name":"审计"},{"code":150307,"name":"风控"}]},{"code":150500,"name":"法务","subLevelModelList":[{"code":150203,"name":"法务"},{"code":150502,"name":"律师"},{"code":150503,"name":"专利"},{"code":150504,"name":"法律顾问"},{"code":150505,"name":"法务专员"},{"code":150506,"name":"法务经理/主管"}]},{"code":150400,"name":"高级管理职位","subLevelModelList":[{"code":150401,"name":"行政总监/经理"},{"code":150402,"name":"财务总监/经理"},{"code":150403,"name":"HRD/HRM"},{"code":150404,"name":"CFO"},{"code":150405,"name":"财务VP"},{"code":150406,"name":"人力资源VP"},{"code":150407,"name":"CEO/总裁/总经理"},{"code":150408,"name":"副总裁/副总经理"},{"code":150409,"name":"事业部负责人"},{"code":150410,"name":"区域/分公司/代表处负责人"},{"code":150411,"name":"总裁/总经理/董事长助理"},{"code":150412,"name":"合伙人"},{"code":150413,"name":"创始人"}]},{"code":150600,"name":"其他职能职位","subLevelModelList":[{"code":150601,"name":"其他职能职位"}]}]},{"code":160000,"name":"销售","subLevelModelList":[{"code":140300,"name":"销售","subLevelModelList":[{"code":140301,"name":"销售专员"},{"code":140302,"name":"销售经理"},{"code":140303,"name":"客户代表"},{"code":140304,"name":"大客户代表"},{"code":140305,"name":"BD经理"},{"code":140306,"name":"商务渠道"},{"code":140307,"name":"渠道销售"},{"code":140308,"name":"代理商销售"},{"code":140309,"name":"销售助理"},{"code":140310,"name":"电话销售"},{"code":140311,"name":"销售顾问"},{"code":140312,"name":"商品经理"},{"code":140313,"name":"广告销售"},{"code":140314,"name":"网络营销"},{"code":140315,"name":"营销主管"}]},{"code":160100,"name":"销售管理","subLevelModelList":[{"code":140402,"name":"销售总监"},{"code":140403,"name":"商务总监"},{"code":160101,"name":"区域总监"},{"code":160102,"name":"城市经理"},{"code":160103,"name":"销售VP"},{"code":160104,"name":"团队经理"}]},{"code":160200,"name":"其他销售职位","subLevelModelList":[{"code":160201,"name":"其他销售职位"}]}]},{"code":170000,"name":"传媒","subLevelModelList":[{"code":170100,"name":"采编/写作/出版","subLevelModelList":[{"code":170101,"name":"记者"},{"code":170102,"name":"编辑"},{"code":170103,"name":"采编"},{"code":170104,"name":"撰稿人"},{"code":170105,"name":"出版发行"},{"code":170106,"name":"校对录入"},{"code":170107,"name":"总编"},{"code":170108,"name":"自媒体"}]},{"code":170300,"name":"公关媒介","subLevelModelList":[{"code":170301,"name":"媒介经理"},{"code":170302,"name":"媒介专员"},{"code":170303,"name":"广告协调"},{"code":170304,"name":"品牌公关"},{"code":170305,"name":"活动策划执行"},{"code":170306,"name":"媒介策划"}]},{"code":170400,"name":"会务会展","subLevelModelList":[{"code":170401,"name":"会议活动销售"},{"code":170402,"name":"会议活动策划"},{"code":170403,"name":"会议活动执行"},{"code":170404,"name":"会展活动销售"},{"code":170405,"name":"会展活动策划"},{"code":170406,"name":"会展活动执行"}]},{"code":170200,"name":"广告","subLevelModelList":[{"code":170201,"name":"广告创意"},{"code":170202,"name":"美术指导"},{"code":170203,"name":"广告设计师"},{"code":170204,"name":"策划经理"},{"code":170205,"name":"文案"},{"code":170206,"name":"资深文案"},{"code":170207,"name":"广告制作"},{"code":170208,"name":"媒介投放"},{"code":170209,"name":"媒介合作"},{"code":170210,"name":"媒介顾问"},{"code":170211,"name":"广告审核"}]},{"code":170600,"name":"影视媒体","subLevelModelList":[{"code":170617,"name":"助理"},{"code":170618,"name":"统筹制片人"},{"code":170619,"name":"执行制片人"},{"code":170601,"name":"导演/编导"},{"code":170602,"name":"摄影/影像师"},{"code":170603,"name":"视频编辑"},{"code":170604,"name":"音频编辑"},{"code":170605,"name":"经纪人"},{"code":170606,"name":"后期制作"},{"code":170607,"name":"影视制作"},{"code":170608,"name":"影视发行"},{"code":170609,"name":"影视策划"},{"code":170610,"name":"主持人/主播/DJ"},{"code":170611,"name":"演员/配音/模特"},{"code":170612,"name":"化妆/造型/服装"},{"code":170613,"name":"放映管理"},{"code":170614,"name":"录音/音效"},{"code":170615,"name":"制片人"},{"code":170616,"name":"编剧"}]},{"code":170500,"name":"其他传媒职位","subLevelModelList":[{"code":170501,"name":"其他传媒职位"}]}]},{"code":180000,"name":"金融","subLevelModelList":[{"code":180100,"name":"投融资","subLevelModelList":[{"code":180101,"name":"投资经理"},{"code":180103,"name":"行业研究"},{"code":180104,"name":"资产管理"},{"code":180112,"name":"投资总监"},{"code":180113,"name":"投资VP"},{"code":180114,"name":"投资合伙人"},{"code":180115,"name":"融资"},{"code":180116,"name":"并购"},{"code":180117,"name":"投后管理"},{"code":180118,"name":"投资助理"},{"code":180111,"name":"其他投融资职位"}]},{"code":180200,"name":"风控","subLevelModelList":[{"code":180201,"name":"风控"},{"code":180202,"name":"律师"},{"code":180203,"name":"资信评估"},{"code":180204,"name":"合规稽查"}]},{"code":180300,"name":"税务审计","subLevelModelList":[{"code":180301,"name":"审计"},{"code":180302,"name":"法务"},{"code":180303,"name":"会计"},{"code":180304,"name":"清算"}]},{"code":180400,"name":"银行","subLevelModelList":[{"code":180401,"name":"信用卡销售"},{"code":180102,"name":"分析师"},{"code":180402,"name":"柜员"},{"code":180403,"name":"商务渠道"},{"code":180404,"name":"大堂经理"},{"code":180105,"name":"理财顾问"},{"code":180405,"name":"客户经理"},{"code":180406,"name":"信贷管理"},{"code":180107,"name":"风控"}]},{"code":180500,"name":"互联网金融","subLevelModelList":[{"code":180501,"name":"金融产品经理"},{"code":180502,"name":"风控"},{"code":180503,"name":"催收员"},{"code":180504,"name":"分析师"},{"code":180505,"name":"投资经理"},{"code":180106,"name":"交易员"},{"code":180506,"name":"理财顾问"},{"code":180108,"name":"合规稽查"},{"code":180109,"name":"审计"},{"code":180110,"name":"清算"}]},{"code":180700,"name":"保险","subLevelModelList":[{"code":180701,"name":"保险业务"},{"code":180702,"name":"精算师"},{"code":180703,"name":"保险理赔"}]},{"code":180600,"name":"其他金融职位","subLevelModelList":[{"code":180601,"name":"其他金融职位"}]}]},{"code":230000,"name":"汽车","subLevelModelList":[{"code":230100,"name":"汽车设计与研发","subLevelModelList":[{"code":230101,"name":"汽车设计"},{"code":230102,"name":"车身设计"},{"code":230103,"name":"底盘设计"},{"code":230104,"name":"机械设计"},{"code":230105,"name":"动力系统设计"},{"code":230106,"name":"电子工程设计"},{"code":230107,"name":"零部件设计"},{"code":230108,"name":"汽车工程项目管理"},{"code":230109,"name":"质量工程师"}]},{"code":230200,"name":"汽车销售与制造","subLevelModelList":[{"code":230201,"name":"汽车销售"},{"code":230202,"name":"汽车配件销售"},{"code":230203,"name":"汽车售后服务"},{"code":230204,"name":"汽车维修"},{"code":230205,"name":"汽车美容"},{"code":230206,"name":"汽车定损理赔"},{"code":230207,"name":"二手车评估师"},{"code":230208,"name":"4S店管理"}]},{"code":230300,"name":"其他汽车职位","subLevelModelList":[{"code":230301,"name":"其他汽车职位"}]}]},{"code":190000,"name":"教育培训","subLevelModelList":[{"code":190100,"name":"教育产品研发","subLevelModelList":[{"code":190101,"name":"课程设计"},{"code":190102,"name":"课程编辑"},{"code":190103,"name":"教师"},{"code":190104,"name":"培训研究"},{"code":190105,"name":"培训师"},{"code":190107,"name":"培训策划"},{"code":190106,"name":"其他教育产品研发职位"}]},{"code":190200,"name":"教育行政","subLevelModelList":[{"code":190201,"name":"校长"},{"code":190202,"name":"教务管理"},{"code":190203,"name":"教学管理"},{"code":190204,"name":"班主任/辅导员"}]},{"code":190300,"name":"教师","subLevelModelList":[{"code":190301,"name":"教师"},{"code":190302,"name":"助教"},{"code":190303,"name":"高中教师"},{"code":190304,"name":"初中教师"},{"code":190305,"name":"小学教师"},{"code":190306,"name":"幼教"},{"code":190307,"name":"理科教师"},{"code":190308,"name":"文科教师"},{"code":190309,"name":"外语教师"},{"code":190310,"name":"音乐教师"},{"code":190311,"name":"美术教师"},{"code":190312,"name":"体育教师"}]},{"code":190400,"name":"IT培训","subLevelModelList":[{"code":190401,"name":"JAVA培训讲师"},{"code":190402,"name":"Android培训讲师"},{"code":190403,"name":"ios培训讲师"},{"code":190404,"name":"PHP培训讲师"},{"code":190405,"name":".NET培训讲师"},{"code":190406,"name":"C++培训讲师"},{"code":190407,"name":"Unity 3D培训讲师"},{"code":190408,"name":"Web前端培训讲师"},{"code":190409,"name":"软件测试培训讲师"},{"code":190410,"name":"动漫培训讲师"},{"code":190411,"name":"UI设计培训讲师"}]},{"code":190500,"name":"职业培训","subLevelModelList":[{"code":190501,"name":"财会培训讲师"},{"code":190502,"name":"HR培训讲师"},{"code":190503,"name":"培训师"}]},{"code":190600,"name":"招生","subLevelModelList":[{"code":190601,"name":"课程顾问"},{"code":190602,"name":"招生顾问"},{"code":190603,"name":"留学顾问"}]},{"code":190700,"name":"教练","subLevelModelList":[{"code":190701,"name":"舞蹈教练"},{"code":190702,"name":"瑜伽教练"},{"code":190703,"name":"瘦身顾问"},{"code":190704,"name":"游泳教练"},{"code":190705,"name":"健身教练"}]},{"code":190800,"name":"其他教育培训职位","subLevelModelList":[{"code":190801,"name":"其他教育培训职位"}]}]},{"code":210000,"name":"医疗健康","subLevelModelList":[{"code":210100,"name":"医疗技术","subLevelModelList":[{"code":210101,"name":"医学编辑"},{"code":210102,"name":"药学编辑"},{"code":210103,"name":"医师"},{"code":210104,"name":"药剂师"},{"code":210105,"name":"医疗器械研究"},{"code":210106,"name":"医学总监"},{"code":210108,"name":"医药研发"},{"code":210109,"name":"验光师"},{"code":210110,"name":"放射科医师"},{"code":210111,"name":"检验科医师"},{"code":210107,"name":"其他医疗技术职位"}]},{"code":210200,"name":"护士/护理","subLevelModelList":[{"code":210201,"name":"护士/护理"}]},{"code":210300,"name":"医师/医生","subLevelModelList":[{"code":210301,"name":"医师"},{"code":210302,"name":"中医"},{"code":210303,"name":"心理医生"},{"code":210304,"name":"牙科医生"},{"code":210305,"name":"康复治疗师"}]},{"code":210400,"name":"健康整形","subLevelModelList":[{"code":210401,"name":"营养师"},{"code":210402,"name":"整形师"},{"code":210403,"name":"理疗师"},{"code":210404,"name":"针灸推拿"},{"code":210405,"name":"美容师/顾问"}]},{"code":210500,"name":"市场销售","subLevelModelList":[{"code":210501,"name":"医学总监"},{"code":210502,"name":"医药代表"},{"code":210503,"name":"导医"},{"code":210504,"name":"健康顾问"},{"code":210505,"name":"医美咨询"}]},{"code":210600,"name":"健身","subLevelModelList":[{"code":210601,"name":"瑜伽教练"},{"code":210602,"name":"瘦身顾问"},{"code":210603,"name":"游泳教练"},{"code":210604,"name":"美体教练"},{"code":210605,"name":"舞蹈教练"},{"code":210606,"name":"健身教练"}]},{"code":210700,"name":"其他医疗健康类职位","subLevelModelList":[{"code":210701,"name":"其他医疗健康类职位"}]}]},{"code":250000,"name":"采购/贸易","subLevelModelList":[{"code":250100,"name":"采购","subLevelModelList":[{"code":250101,"name":"采购总监"},{"code":250102,"name":"采购经理"},{"code":250103,"name":"采购专员"},{"code":250104,"name":"买手"},{"code":250105,"name":"采购工程师"}]},{"code":250200,"name":"进出口贸易","subLevelModelList":[{"code":250201,"name":"外贸经理"},{"code":250202,"name":"外贸专员"},{"code":250203,"name":"外贸业务员"},{"code":250204,"name":"贸易跟单"}]},{"code":250300,"name":"其他采购/贸易职位","subLevelModelList":[{"code":250301,"name":"其他采购/贸易类职位"}]}]},{"code":240000,"name":"供应链/物流","subLevelModelList":[{"code":240100,"name":"物流","subLevelModelList":[{"code":240101,"name":"供应链专员"},{"code":240102,"name":"供应链经理"},{"code":240103,"name":"物流专员"},{"code":240104,"name":"物流经理"},{"code":240105,"name":"物流运营"},{"code":240106,"name":"物流跟单"},{"code":240107,"name":"贸易跟单"},{"code":240108,"name":"物仓调度"},{"code":240109,"name":"物仓项目"},{"code":240110,"name":"运输经理/主管"},{"code":240111,"name":"货运代理专员"},{"code":240112,"name":"货运代理经理"},{"code":240113,"name":"水/空/陆运操作"},{"code":240114,"name":"报关员"},{"code":240115,"name":"报检员"},{"code":240116,"name":"核销员"},{"code":240117,"name":"单证员"}]},{"code":240200,"name":"仓储","subLevelModelList":[{"code":240201,"name":"仓储物料经理"},{"code":240202,"name":"仓储物料专员"},{"code":240203,"name":"仓储物料项目"},{"code":240204,"name":"仓储管理"},{"code":240205,"name":"仓库文员"},{"code":240206,"name":"配/理/拣/发货"}]},{"code":240300,"name":"运输","subLevelModelList":[{"code":240301,"name":"货运司机"},{"code":240302,"name":"集装箱管理"},{"code":240303,"name":"配送"},{"code":240304,"name":"快递"}]},{"code":240400,"name":"高端供应链职位","subLevelModelList":[{"code":240401,"name":"供应链总监"},{"code":240402,"name":"物流总监"}]},{"code":240500,"name":"其他供应链职位","subLevelModelList":[{"code":240501,"name":"其他供应链职位"}]}]},{"code":220000,"name":"房地产/建筑","subLevelModelList":[{"code":220100,"name":"房地产规划开发","subLevelModelList":[{"code":220101,"name":"房产策划"},{"code":220102,"name":"地产项目管理"},{"code":220103,"name":"地产招投标"}]},{"code":220200,"name":"设计装修与市政建设","subLevelModelList":[{"code":220201,"name":"高级建筑工程师"},{"code":220202,"name":"建筑工程师"},{"code":220203,"name":"建筑设计师"},{"code":220204,"name":"土木/土建/结构工程师"},{"code":220205,"name":"室内设计"},{"code":220206,"name":"园林设计"},{"code":220207,"name":"城市规划设计"},{"code":220208,"name":"工程监理"},{"code":220209,"name":"工程造价"},{"code":220210,"name":"预结算"},{"code":220211,"name":"工程资料管理"},{"code":220212,"name":"建筑施工现场管理"}]},{"code":220300,"name":"房地产经纪","subLevelModelList":[{"code":220301,"name":"地产置业顾问"},{"code":220302,"name":"地产评估"},{"code":220303,"name":"地产中介"}]},{"code":220400,"name":"物业管理","subLevelModelList":[{"code":220401,"name":"物业管理"},{"code":220402,"name":"物业租赁销售 "},{"code":220403,"name":"物业招商管理"}]},{"code":220500,"name":"高端房地产职位","subLevelModelList":[{"code":220501,"name":"地产项目总监"},{"code":220502,"name":"地产策划总监"},{"code":220503,"name":"地产招投标总监"},{"code":220504,"name":"物业总监"},{"code":220505,"name":"房地产销售总监"}]},{"code":220600,"name":"其他房地产职位","subLevelModelList":[{"code":220601,"name":"其他房地产职位"}]}]},{"code":260000,"name":"咨询/翻译/法律","subLevelModelList":[{"code":260100,"name":"咨询/调研","subLevelModelList":[{"code":260101,"name":"企业管理咨询"},{"code":260102,"name":"数据分析师"},{"code":260103,"name":"财务咨询顾问"},{"code":260104,"name":"IT咨询顾问"},{"code":260105,"name":"人力资源顾问"},{"code":260106,"name":"咨询项目管理"},{"code":260107,"name":"战略咨询"},{"code":260108,"name":"猎头顾问"},{"code":260109,"name":"市场调研"},{"code":260110,"name":"其他咨询顾问"}]},{"code":260200,"name":"律师","subLevelModelList":[{"code":260201,"name":"事务所律师"},{"code":260202,"name":"公司法务"}]},{"code":260300,"name":"翻译","subLevelModelList":[{"code":260301,"name":"英语翻译"},{"code":260302,"name":"日语翻译"},{"code":260303,"name":"韩语/朝鲜语翻译"},{"code":260304,"name":"法语翻译"},{"code":260305,"name":"德语翻译"},{"code":260306,"name":"俄语翻译"},{"code":260307,"name":"西班牙语翻译"},{"code":260308,"name":"其他语种翻译"}]},{"code":260400,"name":"高端咨询类职位","subLevelModelList":[{"code":260401,"name":"咨询总监"},{"code":260402,"name":"咨询经理"},{"code":260403,"name":"高级翻译"},{"code":260404,"name":"同声传译  "}]},{"code":260500,"name":"其他咨询类职位","subLevelModelList":[{"code":260501,"name":"其他咨询/翻译类职位"}]}]},{"code":270000,"name":"实习生/管培生","subLevelModelList":[{"code":270100,"name":"实习生/培训生/储备干部","subLevelModelList":[{"code":270101,"name":"实习生"},{"code":270102,"name":"管理培训生"},{"code":270103,"name":"储备干部"}]},{"code":270200,"name":"其他实习/培训/储备职位","subLevelModelList":[{"code":270201,"name":"其他实习/培训/储备职位"}]}]},{"code":200000,"name":"其他","subLevelModelList":[{"code":200100,"name":"其他职位类别","subLevelModelList":[{"code":200101,"name":"其他职位"}]}]}]
     * positionWordsCategory : {"100100":602,"100200":602,"100300":603,"100400":604,"100500":604,"100600":605,"100700":607,"100800":606,"100900":602,"101000":624,"101200":665,"101300":666,"110100":608,"110200":608,"110300":608,"120100":609,"120200":609,"120300":608,"120400":609,"120600":662,"130100":610,"130200":611,"130300":612,"130400":613,"140100":614,"140200":614,"140300":616,"140400":615,"140500":614,"140600":614,"150100":618,"150200":619,"150300":620,"150400":622,"150500":621,"160100":617,"170100":625,"170200":614,"170300":614,"170400":614,"170600":640,"180100":626,"180200":641,"180300":642,"180400":643,"180500":644,"180700":663,"190100":627,"190200":645,"190300":646,"190400":647,"190500":648,"190600":649,"190700":650,"200100":623,"210100":628,"210200":651,"210300":652,"210400":653,"210500":654,"210600":655,"220100":629,"220200":630,"220300":631,"220400":632,"220500":633,"230100":634,"230200":635,"240100":636,"240200":637,"240300":638,"240400":639,"250100":656,"250200":657,"260100":658,"260200":659,"260300":660,"260400":661,"270100":664}
     * salary : [{"code":401,"name":"不限"},{"code":402,"name":"3000以下"},{"code":403,"name":"3000-5000"},{"code":404,"name":"5000-10000"},{"code":405,"name":"10000-20000"},{"code":406,"name":"20000-50000"},{"code":407,"name":"50000以上"}]
     * scale : [{"code":301,"name":"0-20人"},{"code":302,"name":"20-99人"},{"code":303,"name":"100-499人"},{"code":304,"name":"500-999人"},{"code":305,"name":"1000-9999人"},{"code":306,"name":"10000人以上"}]
     * stage : [{"code":801,"name":"未融资"},{"code":802,"name":"天使轮"},{"code":803,"name":"A轮"},{"code":804,"name":"B轮"},{"code":805,"name":"C轮"},{"code":806,"name":"D轮及以上"},{"code":807,"name":"已上市"},{"code":808,"name":"不需要融资"}]
     * workCategorywords : {"602":["Java","后端开发","Javascript","数据库","Android","Web前端","iOS","HTML/CSS","HTML5","PHP","移动开发","Linux","系统架构","C/C++","前端开发","需求分析","JS","解决方案",".NET","C#","Python","数据挖掘","Swift","Flash","Node.js","Hadoop","企业软件","游戏开发","Unity3D","机器学习","项目实施","Cocos2d-X","全栈","ERP","系统集成","Shell","通信","ASP","图像算法","中间件","推荐算法","搜索算法","自然语言处理","Golang","网络优化","GO","搜索","Ruby","视频算法","光通信","SAP","java爬虫","python爬虫","Delphi","数据采集","广告算法","VB","信息检索","数据抓取","图像识别","视频编解码","语音算法","NLP","计算机视觉","erlang","VOIP","网络爬虫","Perl","图像编程","人脸识别","爬虫工程师","音频处理","模式识别","音频编解码","WP","视频流转码","抓取","爬虫架构","语音处理","计算广告","流媒体转封装","视频预处理","数字信号处理","目标检测","分布式视频编解码系统","纠错编码","视频识别","数字音频水印"],"603":["功能测试","软件测试","性能测试","web测试","自动化测试","手机测试","黑盒测试","android测试","测试","ios测试","测试开发","硬件测试","游戏测试","web自动化","白盒测试","server端测试","android自动化","windows测试","灰盒测试","ios自动化","windows自动化"],"604":["数据分析","数据库","Linux","运维","系统运维","IT支持","网络","MySQL","数据挖掘","系统管理员","Oracle","机房运维","网络安全","数据处理","运维开发","Windows","SQLServer","信息安全","数据库开发","数据仓库","ETL","安全","数据库管理员","DBA","Hive","Cisco","数据架构","Web安全","IDC","MongoDB","DB2","CDN","病毒分析","密码技术","加密","F5","解密","国密算法","数据压缩","PKI"],"605":["数据库","项目管理","系统架构","需求分析","解决方案","实施","过程管理","文档","PMP","敏捷","CMMI","Prince"],"606":["智能硬件","硬件开发","嵌入式","电路设计","自动化","单片机","系统集成","ARM","PCB工艺","驱动开发","模具设计","手机","材料","传感器","FPGA","射频","DSP","基带","精益","热传导"],"607":["系统架构","技术管理","高级技术管理","运维管理","测试管理"],"608":["数据分析","项目管理","产品经理","APP","移动产品","交互设计","用户研究","产品助理","产品设计师","电子商务","互联网金融","产品总监","智能硬件","O2O","网页产品","商业产品","游戏策划","社交","数据运营","手机游戏","游戏","在线教育","客户端","在线旅游","数值策划","无线产品","游戏制作人","视频","搜索","网页游戏","产品总裁","客户端游戏","SNS","LBS","游戏总监"],"609":["平面设计","UI","网页设计","视觉","App设计","广告设计","电商美工","美工","手绘","3D设计","美术设计","包装设计","交互","CAD/制图","网店设计","插画","工业设计","原画","用户体验","动画","Flash","UE","结构设计","游戏角色","移动交互","影视动画","网页交互","外观设计","游戏场景","UX设计","多媒体","游戏界面","游戏设计","U3D","游戏特效","数值策划","游戏动作","Solidworks","ProE","无线交互","硬件交互"],"610":["活动策划","数据分析","微信运营","运营","新媒体运营","电商运营","网络推广","产品运营","内容运营","app推广","用户运营","SEO","商家运营","微博运营","品牌运营","SEM","线下拓展","APP运营","网站运营","网络运营","社区运营","O2O运营","效果跟踪","策略运营","品类运营","销售支持","游戏运营","客户资源管理","销售培训","业务督导","呼叫中心运营"],"611":["文案","策划","内容编辑","视频编辑","编辑","网站编辑","主编","文档","校对","翻译","采编","电商编辑","记者","旅游","财经","医学","副主编","投标","招标","质量认证","资质认证","ISO内审","ISO外审"],"612":["客服","电话客服","售后咨询","售前咨询","客服代表","电商客服","淘宝客服","天猫客服","O2O客服","游戏客服","地服"],"613":["运营管理","高级运营管理","主编","客服管理"],"614":["市场推广","活动策划","数据分析","市场","微信运营","BD","文案","活动执行","市场策划","网络营销","渠道","app推广","商务","市场分析","地推","品牌","新媒体","SEO","市场顾问","公关","微博运营","广告策划","品牌公关","SEM","媒介","广告创意","互联网广告","会展","促销","平面广告","行业分析","区域","政府关系","AE","海外市场","调研","PR","户外广告","广告协调","视频广告","AM","电视广告","SAE","AD","SAD","AAE"],"615":["市场管理","高级市场管理","公关管理"],"616":["销售","销售代表","销售顾问","电话销售","大客户销售","区域销售","BD","商务渠道","售后支持","渠道分销","代理商销售","售前支持","广告销售"],"617":["销售管理","商务管理"],"618":["招聘","人事","员工关系","HR","培训","薪酬福利","绩效","员工培训","HRBP","渠道培训","电商培训","商家培训"],"619":["行政","助理","文员","前台","后勤","总助","秘书","档案","商务驾驶"],"620":["会计","财务","出纳","税务","总账","审计","应收应付","风控","结算","往来","统计","分析","成本"],"621":["结算","融资","法务","法律","知识产权","信审","专利","债券"],"622":["高级管理","行政管理","人力资源管理","事业部管理","区域管理","合伙管理","财务管理","高级财务管理"],"624":["设备维护","设备调试","设备安装","通信网络优化","LTE","传感器","光通信","通信系统集成","传输线路维护","室内覆盖","无线传输","光传输","基带","传输线路设计","GSM","WCDMA","光网络","天线","通信电源","TD-SCDMA","高层协议","核心网规划","射频传输","核心网优化","物理协议","动力设备维护","CDMA2000","PS域","BTS","BSC","DT","TDL","RNC","GS域"],"625":["策划","文字编辑","主编","网络编辑","校对","撰稿","公众号运营","录入","内容","时尚编辑","出版","自媒体编辑","美术编辑","微信","自媒体运营","发行","论坛编辑","自媒体推广"],"626":["理财","投资","审计","风控","融资","私人财富顾问","金融经纪人","资产管理","证券","信贷","交易","行业研究","清算","PE","经营分析","信审","投后管理","VC","投行","创投","评估","信托业务","天使投资","并购","资金结算","稽核","合规稽查","种子投资","续期理赔","收藏品","权证","定价","收藏品鉴定"],"627":["教师","幼儿教师","小学教师","培训讲师","中学教师","课程设计","课程编辑","培训策划","培训研究","成绩管理","大学教师","高职教师"],"628":["医师","药剂师","医疗咨询","实验员","临床研究","检验科医师","医药研发","医疗器械研究","医学编辑","生物技术研究","中药研究","验光师","制剂研究","放射科医师","药学编辑","药理研究","临床协调CRC","临床监察CRA","MSL"],"629":["地产项目管理","项目策划","项目招投标","开发报建","规划设计","房地产投资分析","开发成本管理","房地产资产管理","配套","地产招采","区域招商","土地管理","土地配套"],"630":["建筑施工","方案设计","装修设计","工程造价","质量管理 ","土建工程","建筑工程","空间设计","预结算","工程资料管理","土木工程","工程监理","结构设计","质量验收","建筑设计","建模","园林设计","城市规划设计","总工","高级建筑工程"],"631":["地产置业顾问","地产销售","地产经纪","地产中介","地产租赁经纪","地产评估"],"632":["物业管理","物业接待","物业项目管理","物业招商管理","物业租赁销售"],"633":["地产销售","地产经纪","团队管理","地产项目管理","项目策划","地产评估","地产招采","地产置业","物业招商","物业租赁"],"634":["质量管理","机械设计","零部件设计","工程项目管理","三维造型设计","装配工艺工程设计","汽车设计","汽车结构功能","内外饰设计","电子工程设计","车身设计","模型制作","动力系统设计","电器工程设计","底盘设计","造型设计","整车架构","改装设计","车身附件设计","混合动力","总线设计","变速器设计","电驱动系统集成","空调系统设计","车灯设计","车身控制系统设计","安全系统设计","功能标定","影音娱乐系统设计","ADAS","减震器设计","色彩面料设计","离合器设计","开闭件设计","消声器设计","滤清器设计"],"635":["汽车维修","汽车售后服务","汽车保养","汽车美容","汽车销售","4S店管理","汽车配件销售","二手车评估","二手车销售","汽车理赔定损"],"636":["物流管理","物流运营","贸易跟单","物流跟单","供应链管理"],"637":["仓储物料管理","发货","理货","配货","调度","打包","拣货","报关","单证","核销","运输","报检","货运代理","陆运操作","水运操作","空运操作"],"638":["配送","货运","驾照","快递","装卸","搬运","集装箱管理"],"639":["贸易跟单","物流跟单","供应链管理","仓储管理","货运代理","物仓调度"],"640":["摄影","剪辑","视频编辑","后期编辑","编导","摄像","影视制作","影视策划","化妆","模特","演员","主播","主持","服装","艺人助理","导演 ","艺人经纪","歌手","造型","播音","配音","动画特效","特效","星探","音频编辑","灯光","3D特效","分镜","艺术指导","录音","编词","音效","道具","剧务","配乐","编曲","舞美设计","乐手","光线特效","放映","爆破特效"],"641":["风险管理","催收","风险分析","风险评估","信贷审批","信贷风险管理","合规审查","核查","授信审查","资信评估","信用管理"],"642":["会计","税务","审计","法务","清算"],"643":["商务渠道","客户经理","个人业务","信贷管理","银行业务","公司业务","柜员","大堂经理","零售业务","信用卡销售","同业金融","对公客户管理","交易咨询","电子银行管理","行长助理","国际业务管理"],"644":["理财","投资","p2p产品","催收","基金产品","信用产品","分析师","证券产品","信托产品","第三方支付产品","众筹产品"],"645":["招生","教务管理","教学管理","班主任","辅导员","校长","幼儿园园长","院长"],"646":["幼教","小学教育","英语教育","助教","初中教育","美术教育","高中教育","数学教育","外语教育","辅导员","语文教育","音乐教育","亲子教育","讲师","理科教育","舞蹈教育","钢琴教育","文科教育","物理教育","体育教育","大学教育","化学教育","计算机教育","生活教育","生物教育","政治教育","历史教育","地理教育"],"647":["JAVA培训","Web前端培训","UI设计培训","Android培训","PHP培训","C++培训","ios培训","Unity3D培训",".NET培训","动漫培训"],"648":["培训","HR培训","财会培训"],"649":["招生","课程顾问","留学"],"650":["健身教练","舞蹈教练","瘦身顾问","瑜伽教练","美体教练","游泳教练"],"651":["护士","护理"],"652":["中医","康复治疗师","内科","检验科医师","口腔治疗","外科","放射科医师","理疗科医师","综合门诊","心理治疗","妇产科医师","儿科医师","预防保健科医师","皮肤科医师","急诊","手术室医师","麻醉科医师","药剂科医师","病理科医师","病案室医生","传染科医师","消毒供应室医师","血库医师"],"653":["美容","理疗","营养咨询","针灸推拿","整形"],"654":["健康顾问","医药代表","医美咨询","导医","医学总监"],"655":["健身教练","舞蹈教练","瘦身顾问","瑜伽教练","美体教练","游泳教练"],"656":["采购","买手","采购工程师"],"657":["贸易跟单","外贸业务","进出口贸易","外贸","单证操作","报关","核销","报检","内销"],"658":["数据分析","需求分析","市场调研","企业管理咨询","咨询项目管理","猎头咨询","人力资源咨询","战略咨询","咨询商务","IT咨询","数据调研","财务咨询","品牌咨询"],"659":["法务","知识产权","律师","合规","专利","商标代理"],"660":["英语翻译","笔译","翻译","口译","日语翻译","韩语/朝鲜语翻译","俄语翻译","法语翻译","西班牙语翻译","同声传译","德语翻译","阿拉伯语翻译","葡萄牙语翻译","泰语翻译","意大利语翻译"],"661":["数据分析","需求分析","英语翻译","市场调研","企业管理咨询","咨询项目管理","猎头咨询","战略咨询","日语翻译","咨询商务","IT咨询","数据调研","人力资源","财务咨询","韩语/朝鲜语翻译","品牌咨询","俄语翻译","法语翻译","西班牙语翻译","德语翻译","阿拉伯语翻译","泰语翻译","意大利语翻译"],"662":["工业设计","家居设计","服装设计","家具设计","橱柜设计","珠宝设计"],"663":["保险","理赔","精算"],"664":["学习能力","综合素质"],"665":["售前技术支持","售后技术支持"],"666":["数据分析","机器学习","算法","人工智能","深度学习"]}
     */

    private String dataVersion;
    private PositionWordsCategoryBean positionWordsCategory;
    private WorkCategorywordsBean workCategorywords;
    private List<BossFilterConfigBean> bossFilterConfig;
    private List<CityBean> city;
    private List<DegreeBean> degree;
    private List<ExperienceBean> experience;
    private List<GeekFilterConfigBean> geekFilterConfig;
    private List<HotCityBean> hotCity;
    private List<IndustryBean> industry;
    private List<IndustryHeaderBean> industryHeader;
    private List<PositionBean> position;
    private List<SalaryBean> salary;
    private List<ScaleBean> scale;
    private List<StageBean> stage;

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public PositionWordsCategoryBean getPositionWordsCategory() {
        return positionWordsCategory;
    }

    public void setPositionWordsCategory(PositionWordsCategoryBean positionWordsCategory) {
        this.positionWordsCategory = positionWordsCategory;
    }

    public WorkCategorywordsBean getWorkCategorywords() {
        return workCategorywords;
    }

    public void setWorkCategorywords(WorkCategorywordsBean workCategorywords) {
        this.workCategorywords = workCategorywords;
    }

    public List<BossFilterConfigBean> getBossFilterConfig() {
        return bossFilterConfig;
    }

    public void setBossFilterConfig(List<BossFilterConfigBean> bossFilterConfig) {
        this.bossFilterConfig = bossFilterConfig;
    }

    public List<CityBean> getCity() {
        return city;
    }

    public void setCity(List<CityBean> city) {
        this.city = city;
    }

    public List<DegreeBean> getDegree() {
        return degree;
    }

    public void setDegree(List<DegreeBean> degree) {
        this.degree = degree;
    }

    public List<ExperienceBean> getExperience() {
        return experience;
    }

    public void setExperience(List<ExperienceBean> experience) {
        this.experience = experience;
    }

    public List<GeekFilterConfigBean> getGeekFilterConfig() {
        return geekFilterConfig;
    }

    public void setGeekFilterConfig(List<GeekFilterConfigBean> geekFilterConfig) {
        this.geekFilterConfig = geekFilterConfig;
    }

    public List<HotCityBean> getHotCity() {
        return hotCity;
    }

    public void setHotCity(List<HotCityBean> hotCity) {
        this.hotCity = hotCity;
    }

    public List<IndustryBean> getIndustry() {
        return industry;
    }

    public void setIndustry(List<IndustryBean> industry) {
        this.industry = industry;
    }

    public List<IndustryHeaderBean> getIndustryHeader() {
        return industryHeader;
    }

    public void setIndustryHeader(List<IndustryHeaderBean> industryHeader) {
        this.industryHeader = industryHeader;
    }

    public List<PositionBean> getPosition() {
        return position;
    }

    public void setPosition(List<PositionBean> position) {
        this.position = position;
    }

    public List<SalaryBean> getSalary() {
        return salary;
    }

    public void setSalary(List<SalaryBean> salary) {
        this.salary = salary;
    }

    public List<ScaleBean> getScale() {
        return scale;
    }

    public void setScale(List<ScaleBean> scale) {
        this.scale = scale;
    }

    public List<StageBean> getStage() {
        return stage;
    }

    public void setStage(List<StageBean> stage) {
        this.stage = stage;
    }

    public static class PositionWordsCategoryBean {
        /**
         * 100100 : 602
         * 100200 : 602
         * 100300 : 603
         * 100400 : 604
         * 100500 : 604
         * 100600 : 605
         * 100700 : 607
         * 100800 : 606
         * 100900 : 602
         * 101000 : 624
         * 101200 : 665
         * 101300 : 666
         * 110100 : 608
         * 110200 : 608
         * 110300 : 608
         * 120100 : 609
         * 120200 : 609
         * 120300 : 608
         * 120400 : 609
         * 120600 : 662
         * 130100 : 610
         * 130200 : 611
         * 130300 : 612
         * 130400 : 613
         * 140100 : 614
         * 140200 : 614
         * 140300 : 616
         * 140400 : 615
         * 140500 : 614
         * 140600 : 614
         * 150100 : 618
         * 150200 : 619
         * 150300 : 620
         * 150400 : 622
         * 150500 : 621
         * 160100 : 617
         * 170100 : 625
         * 170200 : 614
         * 170300 : 614
         * 170400 : 614
         * 170600 : 640
         * 180100 : 626
         * 180200 : 641
         * 180300 : 642
         * 180400 : 643
         * 180500 : 644
         * 180700 : 663
         * 190100 : 627
         * 190200 : 645
         * 190300 : 646
         * 190400 : 647
         * 190500 : 648
         * 190600 : 649
         * 190700 : 650
         * 200100 : 623
         * 210100 : 628
         * 210200 : 651
         * 210300 : 652
         * 210400 : 653
         * 210500 : 654
         * 210600 : 655
         * 220100 : 629
         * 220200 : 630
         * 220300 : 631
         * 220400 : 632
         * 220500 : 633
         * 230100 : 634
         * 230200 : 635
         * 240100 : 636
         * 240200 : 637
         * 240300 : 638
         * 240400 : 639
         * 250100 : 656
         * 250200 : 657
         * 260100 : 658
         * 260200 : 659
         * 260300 : 660
         * 260400 : 661
         * 270100 : 664
         */

        @SerializedName("100100")
        private int _$100100;
        @SerializedName("100200")
        private int _$100200;
        @SerializedName("100300")
        private int _$100300;
        @SerializedName("100400")
        private int _$100400;
        @SerializedName("100500")
        private int _$100500;
        @SerializedName("100600")
        private int _$100600;
        @SerializedName("100700")
        private int _$100700;
        @SerializedName("100800")
        private int _$100800;
        @SerializedName("100900")
        private int _$100900;
        @SerializedName("101000")
        private int _$101000;
        @SerializedName("101200")
        private int _$101200;
        @SerializedName("101300")
        private int _$101300;
        @SerializedName("110100")
        private int _$110100;
        @SerializedName("110200")
        private int _$110200;
        @SerializedName("110300")
        private int _$110300;
        @SerializedName("120100")
        private int _$120100;
        @SerializedName("120200")
        private int _$120200;
        @SerializedName("120300")
        private int _$120300;
        @SerializedName("120400")
        private int _$120400;
        @SerializedName("120600")
        private int _$120600;
        @SerializedName("130100")
        private int _$130100;
        @SerializedName("130200")
        private int _$130200;
        @SerializedName("130300")
        private int _$130300;
        @SerializedName("130400")
        private int _$130400;
        @SerializedName("140100")
        private int _$140100;
        @SerializedName("140200")
        private int _$140200;
        @SerializedName("140300")
        private int _$140300;
        @SerializedName("140400")
        private int _$140400;
        @SerializedName("140500")
        private int _$140500;
        @SerializedName("140600")
        private int _$140600;
        @SerializedName("150100")
        private int _$150100;
        @SerializedName("150200")
        private int _$150200;
        @SerializedName("150300")
        private int _$150300;
        @SerializedName("150400")
        private int _$150400;
        @SerializedName("150500")
        private int _$150500;
        @SerializedName("160100")
        private int _$160100;
        @SerializedName("170100")
        private int _$170100;
        @SerializedName("170200")
        private int _$170200;
        @SerializedName("170300")
        private int _$170300;
        @SerializedName("170400")
        private int _$170400;
        @SerializedName("170600")
        private int _$170600;
        @SerializedName("180100")
        private int _$180100;
        @SerializedName("180200")
        private int _$180200;
        @SerializedName("180300")
        private int _$180300;
        @SerializedName("180400")
        private int _$180400;
        @SerializedName("180500")
        private int _$180500;
        @SerializedName("180700")
        private int _$180700;
        @SerializedName("190100")
        private int _$190100;
        @SerializedName("190200")
        private int _$190200;
        @SerializedName("190300")
        private int _$190300;
        @SerializedName("190400")
        private int _$190400;
        @SerializedName("190500")
        private int _$190500;
        @SerializedName("190600")
        private int _$190600;
        @SerializedName("190700")
        private int _$190700;
        @SerializedName("200100")
        private int _$200100;
        @SerializedName("210100")
        private int _$210100;
        @SerializedName("210200")
        private int _$210200;
        @SerializedName("210300")
        private int _$210300;
        @SerializedName("210400")
        private int _$210400;
        @SerializedName("210500")
        private int _$210500;
        @SerializedName("210600")
        private int _$210600;
        @SerializedName("220100")
        private int _$220100;
        @SerializedName("220200")
        private int _$220200;
        @SerializedName("220300")
        private int _$220300;
        @SerializedName("220400")
        private int _$220400;
        @SerializedName("220500")
        private int _$220500;
        @SerializedName("230100")
        private int _$230100;
        @SerializedName("230200")
        private int _$230200;
        @SerializedName("240100")
        private int _$240100;
        @SerializedName("240200")
        private int _$240200;
        @SerializedName("240300")
        private int _$240300;
        @SerializedName("240400")
        private int _$240400;
        @SerializedName("250100")
        private int _$250100;
        @SerializedName("250200")
        private int _$250200;
        @SerializedName("260100")
        private int _$260100;
        @SerializedName("260200")
        private int _$260200;
        @SerializedName("260300")
        private int _$260300;
        @SerializedName("260400")
        private int _$260400;
        @SerializedName("270100")
        private int _$270100;

        public int get_$100100() {
            return _$100100;
        }

        public void set_$100100(int _$100100) {
            this._$100100 = _$100100;
        }

        public int get_$100200() {
            return _$100200;
        }

        public void set_$100200(int _$100200) {
            this._$100200 = _$100200;
        }

        public int get_$100300() {
            return _$100300;
        }

        public void set_$100300(int _$100300) {
            this._$100300 = _$100300;
        }

        public int get_$100400() {
            return _$100400;
        }

        public void set_$100400(int _$100400) {
            this._$100400 = _$100400;
        }

        public int get_$100500() {
            return _$100500;
        }

        public void set_$100500(int _$100500) {
            this._$100500 = _$100500;
        }

        public int get_$100600() {
            return _$100600;
        }

        public void set_$100600(int _$100600) {
            this._$100600 = _$100600;
        }

        public int get_$100700() {
            return _$100700;
        }

        public void set_$100700(int _$100700) {
            this._$100700 = _$100700;
        }

        public int get_$100800() {
            return _$100800;
        }

        public void set_$100800(int _$100800) {
            this._$100800 = _$100800;
        }

        public int get_$100900() {
            return _$100900;
        }

        public void set_$100900(int _$100900) {
            this._$100900 = _$100900;
        }

        public int get_$101000() {
            return _$101000;
        }

        public void set_$101000(int _$101000) {
            this._$101000 = _$101000;
        }

        public int get_$101200() {
            return _$101200;
        }

        public void set_$101200(int _$101200) {
            this._$101200 = _$101200;
        }

        public int get_$101300() {
            return _$101300;
        }

        public void set_$101300(int _$101300) {
            this._$101300 = _$101300;
        }

        public int get_$110100() {
            return _$110100;
        }

        public void set_$110100(int _$110100) {
            this._$110100 = _$110100;
        }

        public int get_$110200() {
            return _$110200;
        }

        public void set_$110200(int _$110200) {
            this._$110200 = _$110200;
        }

        public int get_$110300() {
            return _$110300;
        }

        public void set_$110300(int _$110300) {
            this._$110300 = _$110300;
        }

        public int get_$120100() {
            return _$120100;
        }

        public void set_$120100(int _$120100) {
            this._$120100 = _$120100;
        }

        public int get_$120200() {
            return _$120200;
        }

        public void set_$120200(int _$120200) {
            this._$120200 = _$120200;
        }

        public int get_$120300() {
            return _$120300;
        }

        public void set_$120300(int _$120300) {
            this._$120300 = _$120300;
        }

        public int get_$120400() {
            return _$120400;
        }

        public void set_$120400(int _$120400) {
            this._$120400 = _$120400;
        }

        public int get_$120600() {
            return _$120600;
        }

        public void set_$120600(int _$120600) {
            this._$120600 = _$120600;
        }

        public int get_$130100() {
            return _$130100;
        }

        public void set_$130100(int _$130100) {
            this._$130100 = _$130100;
        }

        public int get_$130200() {
            return _$130200;
        }

        public void set_$130200(int _$130200) {
            this._$130200 = _$130200;
        }

        public int get_$130300() {
            return _$130300;
        }

        public void set_$130300(int _$130300) {
            this._$130300 = _$130300;
        }

        public int get_$130400() {
            return _$130400;
        }

        public void set_$130400(int _$130400) {
            this._$130400 = _$130400;
        }

        public int get_$140100() {
            return _$140100;
        }

        public void set_$140100(int _$140100) {
            this._$140100 = _$140100;
        }

        public int get_$140200() {
            return _$140200;
        }

        public void set_$140200(int _$140200) {
            this._$140200 = _$140200;
        }

        public int get_$140300() {
            return _$140300;
        }

        public void set_$140300(int _$140300) {
            this._$140300 = _$140300;
        }

        public int get_$140400() {
            return _$140400;
        }

        public void set_$140400(int _$140400) {
            this._$140400 = _$140400;
        }

        public int get_$140500() {
            return _$140500;
        }

        public void set_$140500(int _$140500) {
            this._$140500 = _$140500;
        }

        public int get_$140600() {
            return _$140600;
        }

        public void set_$140600(int _$140600) {
            this._$140600 = _$140600;
        }

        public int get_$150100() {
            return _$150100;
        }

        public void set_$150100(int _$150100) {
            this._$150100 = _$150100;
        }

        public int get_$150200() {
            return _$150200;
        }

        public void set_$150200(int _$150200) {
            this._$150200 = _$150200;
        }

        public int get_$150300() {
            return _$150300;
        }

        public void set_$150300(int _$150300) {
            this._$150300 = _$150300;
        }

        public int get_$150400() {
            return _$150400;
        }

        public void set_$150400(int _$150400) {
            this._$150400 = _$150400;
        }

        public int get_$150500() {
            return _$150500;
        }

        public void set_$150500(int _$150500) {
            this._$150500 = _$150500;
        }

        public int get_$160100() {
            return _$160100;
        }

        public void set_$160100(int _$160100) {
            this._$160100 = _$160100;
        }

        public int get_$170100() {
            return _$170100;
        }

        public void set_$170100(int _$170100) {
            this._$170100 = _$170100;
        }

        public int get_$170200() {
            return _$170200;
        }

        public void set_$170200(int _$170200) {
            this._$170200 = _$170200;
        }

        public int get_$170300() {
            return _$170300;
        }

        public void set_$170300(int _$170300) {
            this._$170300 = _$170300;
        }

        public int get_$170400() {
            return _$170400;
        }

        public void set_$170400(int _$170400) {
            this._$170400 = _$170400;
        }

        public int get_$170600() {
            return _$170600;
        }

        public void set_$170600(int _$170600) {
            this._$170600 = _$170600;
        }

        public int get_$180100() {
            return _$180100;
        }

        public void set_$180100(int _$180100) {
            this._$180100 = _$180100;
        }

        public int get_$180200() {
            return _$180200;
        }

        public void set_$180200(int _$180200) {
            this._$180200 = _$180200;
        }

        public int get_$180300() {
            return _$180300;
        }

        public void set_$180300(int _$180300) {
            this._$180300 = _$180300;
        }

        public int get_$180400() {
            return _$180400;
        }

        public void set_$180400(int _$180400) {
            this._$180400 = _$180400;
        }

        public int get_$180500() {
            return _$180500;
        }

        public void set_$180500(int _$180500) {
            this._$180500 = _$180500;
        }

        public int get_$180700() {
            return _$180700;
        }

        public void set_$180700(int _$180700) {
            this._$180700 = _$180700;
        }

        public int get_$190100() {
            return _$190100;
        }

        public void set_$190100(int _$190100) {
            this._$190100 = _$190100;
        }

        public int get_$190200() {
            return _$190200;
        }

        public void set_$190200(int _$190200) {
            this._$190200 = _$190200;
        }

        public int get_$190300() {
            return _$190300;
        }

        public void set_$190300(int _$190300) {
            this._$190300 = _$190300;
        }

        public int get_$190400() {
            return _$190400;
        }

        public void set_$190400(int _$190400) {
            this._$190400 = _$190400;
        }

        public int get_$190500() {
            return _$190500;
        }

        public void set_$190500(int _$190500) {
            this._$190500 = _$190500;
        }

        public int get_$190600() {
            return _$190600;
        }

        public void set_$190600(int _$190600) {
            this._$190600 = _$190600;
        }

        public int get_$190700() {
            return _$190700;
        }

        public void set_$190700(int _$190700) {
            this._$190700 = _$190700;
        }

        public int get_$200100() {
            return _$200100;
        }

        public void set_$200100(int _$200100) {
            this._$200100 = _$200100;
        }

        public int get_$210100() {
            return _$210100;
        }

        public void set_$210100(int _$210100) {
            this._$210100 = _$210100;
        }

        public int get_$210200() {
            return _$210200;
        }

        public void set_$210200(int _$210200) {
            this._$210200 = _$210200;
        }

        public int get_$210300() {
            return _$210300;
        }

        public void set_$210300(int _$210300) {
            this._$210300 = _$210300;
        }

        public int get_$210400() {
            return _$210400;
        }

        public void set_$210400(int _$210400) {
            this._$210400 = _$210400;
        }

        public int get_$210500() {
            return _$210500;
        }

        public void set_$210500(int _$210500) {
            this._$210500 = _$210500;
        }

        public int get_$210600() {
            return _$210600;
        }

        public void set_$210600(int _$210600) {
            this._$210600 = _$210600;
        }

        public int get_$220100() {
            return _$220100;
        }

        public void set_$220100(int _$220100) {
            this._$220100 = _$220100;
        }

        public int get_$220200() {
            return _$220200;
        }

        public void set_$220200(int _$220200) {
            this._$220200 = _$220200;
        }

        public int get_$220300() {
            return _$220300;
        }

        public void set_$220300(int _$220300) {
            this._$220300 = _$220300;
        }

        public int get_$220400() {
            return _$220400;
        }

        public void set_$220400(int _$220400) {
            this._$220400 = _$220400;
        }

        public int get_$220500() {
            return _$220500;
        }

        public void set_$220500(int _$220500) {
            this._$220500 = _$220500;
        }

        public int get_$230100() {
            return _$230100;
        }

        public void set_$230100(int _$230100) {
            this._$230100 = _$230100;
        }

        public int get_$230200() {
            return _$230200;
        }

        public void set_$230200(int _$230200) {
            this._$230200 = _$230200;
        }

        public int get_$240100() {
            return _$240100;
        }

        public void set_$240100(int _$240100) {
            this._$240100 = _$240100;
        }

        public int get_$240200() {
            return _$240200;
        }

        public void set_$240200(int _$240200) {
            this._$240200 = _$240200;
        }

        public int get_$240300() {
            return _$240300;
        }

        public void set_$240300(int _$240300) {
            this._$240300 = _$240300;
        }

        public int get_$240400() {
            return _$240400;
        }

        public void set_$240400(int _$240400) {
            this._$240400 = _$240400;
        }

        public int get_$250100() {
            return _$250100;
        }

        public void set_$250100(int _$250100) {
            this._$250100 = _$250100;
        }

        public int get_$250200() {
            return _$250200;
        }

        public void set_$250200(int _$250200) {
            this._$250200 = _$250200;
        }

        public int get_$260100() {
            return _$260100;
        }

        public void set_$260100(int _$260100) {
            this._$260100 = _$260100;
        }

        public int get_$260200() {
            return _$260200;
        }

        public void set_$260200(int _$260200) {
            this._$260200 = _$260200;
        }

        public int get_$260300() {
            return _$260300;
        }

        public void set_$260300(int _$260300) {
            this._$260300 = _$260300;
        }

        public int get_$260400() {
            return _$260400;
        }

        public void set_$260400(int _$260400) {
            this._$260400 = _$260400;
        }

        public int get_$270100() {
            return _$270100;
        }

        public void set_$270100(int _$270100) {
            this._$270100 = _$270100;
        }
    }

    public static class WorkCategorywordsBean {
        @SerializedName("602")
        private List<String> _$602;
        @SerializedName("603")
        private List<String> _$603;
        @SerializedName("604")
        private List<String> _$604;
        @SerializedName("605")
        private List<String> _$605;
        @SerializedName("606")
        private List<String> _$606;
        @SerializedName("607")
        private List<String> _$607;
        @SerializedName("608")
        private List<String> _$608;
        @SerializedName("609")
        private List<String> _$609;
        @SerializedName("610")
        private List<String> _$610;
        @SerializedName("611")
        private List<String> _$611;
        @SerializedName("612")
        private List<String> _$612;
        @SerializedName("613")
        private List<String> _$613;
        @SerializedName("614")
        private List<String> _$614;
        @SerializedName("615")
        private List<String> _$615;
        @SerializedName("616")
        private List<String> _$616;
        @SerializedName("617")
        private List<String> _$617;
        @SerializedName("618")
        private List<String> _$618;
        @SerializedName("619")
        private List<String> _$619;
        @SerializedName("620")
        private List<String> _$620;
        @SerializedName("621")
        private List<String> _$621;
        @SerializedName("622")
        private List<String> _$622;
        @SerializedName("624")
        private List<String> _$624;
        @SerializedName("625")
        private List<String> _$625;
        @SerializedName("626")
        private List<String> _$626;
        @SerializedName("627")
        private List<String> _$627;
        @SerializedName("628")
        private List<String> _$628;
        @SerializedName("629")
        private List<String> _$629;
        @SerializedName("630")
        private List<String> _$630;
        @SerializedName("631")
        private List<String> _$631;
        @SerializedName("632")
        private List<String> _$632;
        @SerializedName("633")
        private List<String> _$633;
        @SerializedName("634")
        private List<String> _$634;
        @SerializedName("635")
        private List<String> _$635;
        @SerializedName("636")
        private List<String> _$636;
        @SerializedName("637")
        private List<String> _$637;
        @SerializedName("638")
        private List<String> _$638;
        @SerializedName("639")
        private List<String> _$639;
        @SerializedName("640")
        private List<String> _$640;
        @SerializedName("641")
        private List<String> _$641;
        @SerializedName("642")
        private List<String> _$642;
        @SerializedName("643")
        private List<String> _$643;
        @SerializedName("644")
        private List<String> _$644;
        @SerializedName("645")
        private List<String> _$645;
        @SerializedName("646")
        private List<String> _$646;
        @SerializedName("647")
        private List<String> _$647;
        @SerializedName("648")
        private List<String> _$648;
        @SerializedName("649")
        private List<String> _$649;
        @SerializedName("650")
        private List<String> _$650;
        @SerializedName("651")
        private List<String> _$651;
        @SerializedName("652")
        private List<String> _$652;
        @SerializedName("653")
        private List<String> _$653;
        @SerializedName("654")
        private List<String> _$654;
        @SerializedName("655")
        private List<String> _$655;
        @SerializedName("656")
        private List<String> _$656;
        @SerializedName("657")
        private List<String> _$657;
        @SerializedName("658")
        private List<String> _$658;
        @SerializedName("659")
        private List<String> _$659;
        @SerializedName("660")
        private List<String> _$660;
        @SerializedName("661")
        private List<String> _$661;
        @SerializedName("662")
        private List<String> _$662;
        @SerializedName("663")
        private List<String> _$663;
        @SerializedName("664")
        private List<String> _$664;
        @SerializedName("665")
        private List<String> _$665;
        @SerializedName("666")
        private List<String> _$666;

        public List<String> get_$602() {
            return _$602;
        }

        public void set_$602(List<String> _$602) {
            this._$602 = _$602;
        }

        public List<String> get_$603() {
            return _$603;
        }

        public void set_$603(List<String> _$603) {
            this._$603 = _$603;
        }

        public List<String> get_$604() {
            return _$604;
        }

        public void set_$604(List<String> _$604) {
            this._$604 = _$604;
        }

        public List<String> get_$605() {
            return _$605;
        }

        public void set_$605(List<String> _$605) {
            this._$605 = _$605;
        }

        public List<String> get_$606() {
            return _$606;
        }

        public void set_$606(List<String> _$606) {
            this._$606 = _$606;
        }

        public List<String> get_$607() {
            return _$607;
        }

        public void set_$607(List<String> _$607) {
            this._$607 = _$607;
        }

        public List<String> get_$608() {
            return _$608;
        }

        public void set_$608(List<String> _$608) {
            this._$608 = _$608;
        }

        public List<String> get_$609() {
            return _$609;
        }

        public void set_$609(List<String> _$609) {
            this._$609 = _$609;
        }

        public List<String> get_$610() {
            return _$610;
        }

        public void set_$610(List<String> _$610) {
            this._$610 = _$610;
        }

        public List<String> get_$611() {
            return _$611;
        }

        public void set_$611(List<String> _$611) {
            this._$611 = _$611;
        }

        public List<String> get_$612() {
            return _$612;
        }

        public void set_$612(List<String> _$612) {
            this._$612 = _$612;
        }

        public List<String> get_$613() {
            return _$613;
        }

        public void set_$613(List<String> _$613) {
            this._$613 = _$613;
        }

        public List<String> get_$614() {
            return _$614;
        }

        public void set_$614(List<String> _$614) {
            this._$614 = _$614;
        }

        public List<String> get_$615() {
            return _$615;
        }

        public void set_$615(List<String> _$615) {
            this._$615 = _$615;
        }

        public List<String> get_$616() {
            return _$616;
        }

        public void set_$616(List<String> _$616) {
            this._$616 = _$616;
        }

        public List<String> get_$617() {
            return _$617;
        }

        public void set_$617(List<String> _$617) {
            this._$617 = _$617;
        }

        public List<String> get_$618() {
            return _$618;
        }

        public void set_$618(List<String> _$618) {
            this._$618 = _$618;
        }

        public List<String> get_$619() {
            return _$619;
        }

        public void set_$619(List<String> _$619) {
            this._$619 = _$619;
        }

        public List<String> get_$620() {
            return _$620;
        }

        public void set_$620(List<String> _$620) {
            this._$620 = _$620;
        }

        public List<String> get_$621() {
            return _$621;
        }

        public void set_$621(List<String> _$621) {
            this._$621 = _$621;
        }

        public List<String> get_$622() {
            return _$622;
        }

        public void set_$622(List<String> _$622) {
            this._$622 = _$622;
        }

        public List<String> get_$624() {
            return _$624;
        }

        public void set_$624(List<String> _$624) {
            this._$624 = _$624;
        }

        public List<String> get_$625() {
            return _$625;
        }

        public void set_$625(List<String> _$625) {
            this._$625 = _$625;
        }

        public List<String> get_$626() {
            return _$626;
        }

        public void set_$626(List<String> _$626) {
            this._$626 = _$626;
        }

        public List<String> get_$627() {
            return _$627;
        }

        public void set_$627(List<String> _$627) {
            this._$627 = _$627;
        }

        public List<String> get_$628() {
            return _$628;
        }

        public void set_$628(List<String> _$628) {
            this._$628 = _$628;
        }

        public List<String> get_$629() {
            return _$629;
        }

        public void set_$629(List<String> _$629) {
            this._$629 = _$629;
        }

        public List<String> get_$630() {
            return _$630;
        }

        public void set_$630(List<String> _$630) {
            this._$630 = _$630;
        }

        public List<String> get_$631() {
            return _$631;
        }

        public void set_$631(List<String> _$631) {
            this._$631 = _$631;
        }

        public List<String> get_$632() {
            return _$632;
        }

        public void set_$632(List<String> _$632) {
            this._$632 = _$632;
        }

        public List<String> get_$633() {
            return _$633;
        }

        public void set_$633(List<String> _$633) {
            this._$633 = _$633;
        }

        public List<String> get_$634() {
            return _$634;
        }

        public void set_$634(List<String> _$634) {
            this._$634 = _$634;
        }

        public List<String> get_$635() {
            return _$635;
        }

        public void set_$635(List<String> _$635) {
            this._$635 = _$635;
        }

        public List<String> get_$636() {
            return _$636;
        }

        public void set_$636(List<String> _$636) {
            this._$636 = _$636;
        }

        public List<String> get_$637() {
            return _$637;
        }

        public void set_$637(List<String> _$637) {
            this._$637 = _$637;
        }

        public List<String> get_$638() {
            return _$638;
        }

        public void set_$638(List<String> _$638) {
            this._$638 = _$638;
        }

        public List<String> get_$639() {
            return _$639;
        }

        public void set_$639(List<String> _$639) {
            this._$639 = _$639;
        }

        public List<String> get_$640() {
            return _$640;
        }

        public void set_$640(List<String> _$640) {
            this._$640 = _$640;
        }

        public List<String> get_$641() {
            return _$641;
        }

        public void set_$641(List<String> _$641) {
            this._$641 = _$641;
        }

        public List<String> get_$642() {
            return _$642;
        }

        public void set_$642(List<String> _$642) {
            this._$642 = _$642;
        }

        public List<String> get_$643() {
            return _$643;
        }

        public void set_$643(List<String> _$643) {
            this._$643 = _$643;
        }

        public List<String> get_$644() {
            return _$644;
        }

        public void set_$644(List<String> _$644) {
            this._$644 = _$644;
        }

        public List<String> get_$645() {
            return _$645;
        }

        public void set_$645(List<String> _$645) {
            this._$645 = _$645;
        }

        public List<String> get_$646() {
            return _$646;
        }

        public void set_$646(List<String> _$646) {
            this._$646 = _$646;
        }

        public List<String> get_$647() {
            return _$647;
        }

        public void set_$647(List<String> _$647) {
            this._$647 = _$647;
        }

        public List<String> get_$648() {
            return _$648;
        }

        public void set_$648(List<String> _$648) {
            this._$648 = _$648;
        }

        public List<String> get_$649() {
            return _$649;
        }

        public void set_$649(List<String> _$649) {
            this._$649 = _$649;
        }

        public List<String> get_$650() {
            return _$650;
        }

        public void set_$650(List<String> _$650) {
            this._$650 = _$650;
        }

        public List<String> get_$651() {
            return _$651;
        }

        public void set_$651(List<String> _$651) {
            this._$651 = _$651;
        }

        public List<String> get_$652() {
            return _$652;
        }

        public void set_$652(List<String> _$652) {
            this._$652 = _$652;
        }

        public List<String> get_$653() {
            return _$653;
        }

        public void set_$653(List<String> _$653) {
            this._$653 = _$653;
        }

        public List<String> get_$654() {
            return _$654;
        }

        public void set_$654(List<String> _$654) {
            this._$654 = _$654;
        }

        public List<String> get_$655() {
            return _$655;
        }

        public void set_$655(List<String> _$655) {
            this._$655 = _$655;
        }

        public List<String> get_$656() {
            return _$656;
        }

        public void set_$656(List<String> _$656) {
            this._$656 = _$656;
        }

        public List<String> get_$657() {
            return _$657;
        }

        public void set_$657(List<String> _$657) {
            this._$657 = _$657;
        }

        public List<String> get_$658() {
            return _$658;
        }

        public void set_$658(List<String> _$658) {
            this._$658 = _$658;
        }

        public List<String> get_$659() {
            return _$659;
        }

        public void set_$659(List<String> _$659) {
            this._$659 = _$659;
        }

        public List<String> get_$660() {
            return _$660;
        }

        public void set_$660(List<String> _$660) {
            this._$660 = _$660;
        }

        public List<String> get_$661() {
            return _$661;
        }

        public void set_$661(List<String> _$661) {
            this._$661 = _$661;
        }

        public List<String> get_$662() {
            return _$662;
        }

        public void set_$662(List<String> _$662) {
            this._$662 = _$662;
        }

        public List<String> get_$663() {
            return _$663;
        }

        public void set_$663(List<String> _$663) {
            this._$663 = _$663;
        }

        public List<String> get_$664() {
            return _$664;
        }

        public void set_$664(List<String> _$664) {
            this._$664 = _$664;
        }

        public List<String> get_$665() {
            return _$665;
        }

        public void set_$665(List<String> _$665) {
            this._$665 = _$665;
        }

        public List<String> get_$666() {
            return _$666;
        }

        public void set_$666(List<String> _$666) {
            this._$666 = _$666;
        }
    }

    public static class BossFilterConfigBean {
        /**
         * code : 200
         * name : 学历
         * paramName : degree
         * subFilterConfigModel : [{"code":0,"name":"全部"},{"code":207,"name":"中专及以下"},{"code":206,"name":"高中"},{"code":202,"name":"大专"},{"code":203,"name":"本科"},{"code":204,"name":"硕士"},{"code":205,"name":"博士"}]
         */

        private int code;
        private String name;
        private String paramName;
        private List<SubFilterConfigModelBean> subFilterConfigModel;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public List<SubFilterConfigModelBean> getSubFilterConfigModel() {
            return subFilterConfigModel;
        }

        public void setSubFilterConfigModel(List<SubFilterConfigModelBean> subFilterConfigModel) {
            this.subFilterConfigModel = subFilterConfigModel;
        }

        public static class SubFilterConfigModelBean {
            /**
             * code : 0
             * name : 全部
             */

            private int code;
            private String name;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class CityBean {
        /**
         * code : 101010000
         * firstChar : b
         * name : 北京
         * subLevelModelList : [{"code":101010100,"firstChar":"b","name":"北京","subLevelModelList":[{"code":110101,"firstChar":"","name":"东城区"},{"code":110102,"firstChar":"","name":"西城区"},{"code":110105,"firstChar":"","name":"朝阳区"},{"code":110106,"firstChar":"","name":"丰台区"},{"code":110107,"firstChar":"","name":"石景山区"},{"code":110108,"firstChar":"","name":"海淀区"},{"code":110109,"firstChar":"","name":"门头沟区"},{"code":110111,"firstChar":"","name":"房山区"},{"code":110112,"firstChar":"","name":"通州区"},{"code":110113,"firstChar":"","name":"顺义区"},{"code":110114,"firstChar":"","name":"昌平区"},{"code":110115,"firstChar":"","name":"大兴区"},{"code":110116,"firstChar":"","name":"怀柔区"},{"code":110117,"firstChar":"","name":"平谷区"},{"code":110118,"firstChar":"","name":"密云区"},{"code":110119,"firstChar":"","name":"延庆区"}]}]
         */

        private int code;
        private String firstChar;
        private String name;
        private List<SubLevelModelListBeanX> subLevelModelList;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getFirstChar() {
            return firstChar;
        }

        public void setFirstChar(String firstChar) {
            this.firstChar = firstChar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubLevelModelListBeanX> getSubLevelModelList() {
            return subLevelModelList;
        }

        public void setSubLevelModelList(List<SubLevelModelListBeanX> subLevelModelList) {
            this.subLevelModelList = subLevelModelList;
        }

        public static class SubLevelModelListBeanX {
            /**
             * code : 101010100
             * firstChar : b
             * name : 北京
             * subLevelModelList : [{"code":110101,"firstChar":"","name":"东城区"},{"code":110102,"firstChar":"","name":"西城区"},{"code":110105,"firstChar":"","name":"朝阳区"},{"code":110106,"firstChar":"","name":"丰台区"},{"code":110107,"firstChar":"","name":"石景山区"},{"code":110108,"firstChar":"","name":"海淀区"},{"code":110109,"firstChar":"","name":"门头沟区"},{"code":110111,"firstChar":"","name":"房山区"},{"code":110112,"firstChar":"","name":"通州区"},{"code":110113,"firstChar":"","name":"顺义区"},{"code":110114,"firstChar":"","name":"昌平区"},{"code":110115,"firstChar":"","name":"大兴区"},{"code":110116,"firstChar":"","name":"怀柔区"},{"code":110117,"firstChar":"","name":"平谷区"},{"code":110118,"firstChar":"","name":"密云区"},{"code":110119,"firstChar":"","name":"延庆区"}]
             */

            private int code;
            private String firstChar;
            private String name;
            private List<SubLevelModelListBean> subLevelModelList;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getFirstChar() {
                return firstChar;
            }

            public void setFirstChar(String firstChar) {
                this.firstChar = firstChar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubLevelModelListBean> getSubLevelModelList() {
                return subLevelModelList;
            }

            public void setSubLevelModelList(List<SubLevelModelListBean> subLevelModelList) {
                this.subLevelModelList = subLevelModelList;
            }

            public static class SubLevelModelListBean {
                /**
                 * code : 110101
                 * firstChar :
                 * name : 东城区
                 */

                private int code;
                private String firstChar;
                private String name;

                public int getCode() {
                    return code;
                }

                public void setCode(int code) {
                    this.code = code;
                }

                public String getFirstChar() {
                    return firstChar;
                }

                public void setFirstChar(String firstChar) {
                    this.firstChar = firstChar;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }

    public static class DegreeBean {
        /**
         * code : 201
         * name : 不限
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ExperienceBean {
        /**
         * code : 101
         * name : 不限
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class GeekFilterConfigBean {
        /**
         * code : 400
         * name : 薪水
         * paramName : salary
         * subFilterConfigModel : [{"code":0,"name":"全部"},{"code":402,"name":"3k以下"},{"code":403,"name":"3k-5k"},{"code":404,"name":"5k-10k"},{"code":405,"name":"10k-20k"},{"code":406,"name":"20k-50k"},{"code":407,"name":"50k以上"}]
         */

        private int code;
        private String name;
        private String paramName;
        private List<SubFilterConfigModelBeanX> subFilterConfigModel;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public List<SubFilterConfigModelBeanX> getSubFilterConfigModel() {
            return subFilterConfigModel;
        }

        public void setSubFilterConfigModel(List<SubFilterConfigModelBeanX> subFilterConfigModel) {
            this.subFilterConfigModel = subFilterConfigModel;
        }

        public static class SubFilterConfigModelBeanX {
            /**
             * code : 0
             * name : 全部
             */

            private int code;
            private String name;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    public static class HotCityBean {
        /**
         * code : 0
         * name : 全国
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class IndustryBean {
        /**
         * code : 502
         * name : 健康医疗
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class IndustryHeaderBean {
        /**
         * code : 100100
         * name : 互联网
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class PositionBean {
        /**
         * code : 100000
         * name : 技术
         * subLevelModelList : [{"code":100100,"name":"后端开发","subLevelModelList":[{"code":100101,"name":"Java"},{"code":100102,"name":"C++"},{"code":100103,"name":"PHP"},{"code":100104,"name":"数据挖掘"},{"code":100105,"name":"C"},{"code":100106,"name":"C#"},{"code":100107,"name":".NET"},{"code":100108,"name":"Hadoop"},{"code":100109,"name":"Python"},{"code":100110,"name":"Delphi"},{"code":100111,"name":"VB"},{"code":100112,"name":"Perl"},{"code":100113,"name":"Ruby"},{"code":100114,"name":"Node.js"},{"code":100115,"name":"搜索算法"},{"code":100116,"name":"Golang"},{"code":100117,"name":"自然语言处理"},{"code":100118,"name":"推荐算法"},{"code":100119,"name":"Erlang"},{"code":100120,"name":"算法工程师"},{"code":100121,"name":"语音/视频/图形开发"},{"code":100122,"name":"数据采集"}]},{"code":100200,"name":"移动开发","subLevelModelList":[{"code":100201,"name":"HTML5"},{"code":100202,"name":"Android"},{"code":100203,"name":"iOS"},{"code":100204,"name":"WP"},{"code":100205,"name":"Web前端"},{"code":100206,"name":"Flash"},{"code":100208,"name":"JavaScript"},{"code":100209,"name":"U3D"},{"code":100210,"name":"COCOS2DX"}]},{"code":100300,"name":"测试","subLevelModelList":[{"code":100301,"name":"测试工程师"},{"code":100302,"name":"自动化测试"},{"code":100303,"name":"功能测试"},{"code":100304,"name":"性能测试"},{"code":100305,"name":"测试开发"},{"code":100306,"name":"移动端测试"},{"code":100307,"name":"游戏测试"},{"code":100308,"name":"硬件测试"},{"code":100309,"name":"软件测试"}]},{"code":100400,"name":"运维/技术支持","subLevelModelList":[{"code":100401,"name":"运维工程师"},{"code":100402,"name":"运维开发工程师"},{"code":100403,"name":"网络工程师"},{"code":100404,"name":"系统工程师"},{"code":100405,"name":"IT技术支持"},{"code":100406,"name":"系统管理员"},{"code":100407,"name":"网络安全"},{"code":100408,"name":"系统安全"},{"code":100409,"name":"DBA"}]},{"code":100500,"name":"数据","subLevelModelList":[{"code":100506,"name":"ETL工程师"},{"code":100507,"name":"数据仓库"},{"code":100508,"name":"数据开发"},{"code":100509,"name":"数据挖掘"},{"code":100510,"name":"数据处理工程师"},{"code":100511,"name":"数据分析师"},{"code":100512,"name":"数据架构师"}]},{"code":100600,"name":"项目管理","subLevelModelList":[{"code":100601,"name":"项目经理"},{"code":100602,"name":"项目主管"},{"code":100603,"name":"项目助理"},{"code":100604,"name":"项目专员"},{"code":100605,"name":"实施顾问"},{"code":100606,"name":"实施工程师"},{"code":100607,"name":"需求分析工程师"}]},{"code":100800,"name":"硬件开发","subLevelModelList":[{"code":100801,"name":"硬件"},{"code":100802,"name":"嵌入式"},{"code":100803,"name":"自动化"},{"code":100804,"name":"单片机"},{"code":100805,"name":"电路设计"},{"code":100806,"name":"驱动开发"},{"code":100807,"name":"系统集成"},{"code":100808,"name":"FPGA开发"},{"code":100809,"name":"DSP开发"},{"code":100810,"name":"ARM开发"},{"code":100811,"name":"PCB工艺"},{"code":100812,"name":"模具设计"},{"code":100813,"name":"热传导"},{"code":100814,"name":"材料工程师"},{"code":100815,"name":"精益工程师"},{"code":100816,"name":"射频工程师"}]},{"code":100900,"name":"前端开发","subLevelModelList":[{"code":100901,"name":"web前端"},{"code":100902,"name":"Javascript"},{"code":100903,"name":"Flash"},{"code":100904,"name":"HTML5"}]},{"code":101000,"name":"通信","subLevelModelList":[{"code":101001,"name":"通信技术工程师"},{"code":101002,"name":"通信研发工程师"},{"code":101003,"name":"数据通信工程师"},{"code":101004,"name":"移动通信工程师"},{"code":101005,"name":"电信网络工程师"},{"code":101006,"name":"电信交换工程师"},{"code":101007,"name":"有线传输工程师"},{"code":101008,"name":"无线射频工程师"},{"code":101009,"name":"通信电源工程师"},{"code":101010,"name":"通信标准化工程师"},{"code":101011,"name":"通信项目专员"},{"code":101012,"name":"通信项目经理"},{"code":101013,"name":"核心网工程师"},{"code":101014,"name":"通信测试工程师"},{"code":101015,"name":"通信设备工程师"},{"code":101016,"name":"光通信工程师"},{"code":101017,"name":"光传输工程师"},{"code":101018,"name":"光网络工程师"}]},{"code":100700,"name":"高端技术职位","subLevelModelList":[{"code":100701,"name":"技术经理"},{"code":100702,"name":"技术总监"},{"code":100703,"name":"测试经理"},{"code":100704,"name":"架构师"},{"code":100705,"name":"CTO"},{"code":100706,"name":"运维总监"},{"code":100707,"name":"技术合伙人"}]},{"code":101300,"name":"人工智能","subLevelModelList":[{"code":101301,"name":"机器学习"},{"code":101302,"name":"深度学习"},{"code":101303,"name":"图像算法"},{"code":101304,"name":"图像处理"},{"code":101305,"name":"语音识别"},{"code":101306,"name":"图像识别"}]},{"code":101200,"name":"软件销售支持","subLevelModelList":[{"code":101201,"name":"售前工程师"},{"code":101202,"name":"售后工程师"}]},{"code":101100,"name":"其他技术职位","subLevelModelList":[{"code":101101,"name":"其他技术职位"}]}]
         */

        private int code;
        private String name;
        private List<SubLevelModelListBeanXXX> subLevelModelList;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SubLevelModelListBeanXXX> getSubLevelModelList() {
            return subLevelModelList;
        }

        public void setSubLevelModelList(List<SubLevelModelListBeanXXX> subLevelModelList) {
            this.subLevelModelList = subLevelModelList;
        }

        public static class SubLevelModelListBeanXXX {
            /**
             * code : 100100
             * name : 后端开发
             * subLevelModelList : [{"code":100101,"name":"Java"},{"code":100102,"name":"C++"},{"code":100103,"name":"PHP"},{"code":100104,"name":"数据挖掘"},{"code":100105,"name":"C"},{"code":100106,"name":"C#"},{"code":100107,"name":".NET"},{"code":100108,"name":"Hadoop"},{"code":100109,"name":"Python"},{"code":100110,"name":"Delphi"},{"code":100111,"name":"VB"},{"code":100112,"name":"Perl"},{"code":100113,"name":"Ruby"},{"code":100114,"name":"Node.js"},{"code":100115,"name":"搜索算法"},{"code":100116,"name":"Golang"},{"code":100117,"name":"自然语言处理"},{"code":100118,"name":"推荐算法"},{"code":100119,"name":"Erlang"},{"code":100120,"name":"算法工程师"},{"code":100121,"name":"语音/视频/图形开发"},{"code":100122,"name":"数据采集"}]
             */

            private int code;
            private String name;
            private List<SubLevelModelListBeanXX> subLevelModelList;

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SubLevelModelListBeanXX> getSubLevelModelList() {
                return subLevelModelList;
            }

            public void setSubLevelModelList(List<SubLevelModelListBeanXX> subLevelModelList) {
                this.subLevelModelList = subLevelModelList;
            }

            public static class SubLevelModelListBeanXX {
                /**
                 * code : 100101
                 * name : Java
                 */

                private int code;
                private String name;

                public int getCode() {
                    return code;
                }

                public void setCode(int code) {
                    this.code = code;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }

    public static class SalaryBean {
        /**
         * code : 401
         * name : 不限
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ScaleBean {
        /**
         * code : 301
         * name : 0-20人
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class StageBean {
        /**
         * code : 801
         * name : 未融资
         */

        private int code;
        private String name;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
