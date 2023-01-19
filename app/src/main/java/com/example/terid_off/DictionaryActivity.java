package com.example.terid_off;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

public class DictionaryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private DictionaryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<DictionaryItem> mExampleList;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        createExampleList();
        buildRecyclerView();

        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }

        });

        // Toolbar 설정
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
    }

    // Toolbar back button 설정
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void filter(String text) {
        ArrayList<DictionaryItem> filteredList = new ArrayList<>();

        for (DictionaryItem item : mExampleList) {
            if (item.getText1().toLowerCase().contains(text.toLowerCase()) || item.getText2().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);

    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new DictionaryItem("abstain from", "삼가다, 그만두다")); mExampleList.add(new DictionaryItem("abudance", "풍부, 풍성, 풍부함"));
        mExampleList.add(new DictionaryItem("acclaimed", "호평을 받는, 칭찬을 받고 있는")); mExampleList.add(new DictionaryItem("accomplishment", "성과, 업적(공적), 기량, 완수"));
        mExampleList.add(new DictionaryItem("administration", "정부, 내각")); mExampleList.add(new DictionaryItem("admittance", "입원, 입장, 들어감, 인정"));
        mExampleList.add(new DictionaryItem("admonish", "꾸짖다, 책망하다, 충고하다")); mExampleList.add(new DictionaryItem("advocate", "변호하다, 지지하다, 변호사"));
        mExampleList.add(new DictionaryItem("affected", "영향을 받는")); mExampleList.add(new DictionaryItem("aggressive", "적극적인, 공격적인"));
        mExampleList.add(new DictionaryItem("air ventilation", "환기")); mExampleList.add(new DictionaryItem("allocate", "할당하다, 분배하다"));
        mExampleList.add(new DictionaryItem("allow for", "감안하다, 잡아 두다, 고려하다")); mExampleList.add(new DictionaryItem("allowance", "수당, 용돈, 허용량"));
        mExampleList.add(new DictionaryItem("alteration", "변경, 수정, 변화, 개조")); mExampleList.add(new DictionaryItem("anniversary", "기념일"));
        mExampleList.add(new DictionaryItem("anxiety", "불안, 걱정, 걱정거리, 열망")); mExampleList.add(new DictionaryItem("appealing", "매력적인, 흥미로운"));
        mExampleList.add(new DictionaryItem("appealing", "매력적인, 흥미로운")); mExampleList.add(new DictionaryItem("appliances", "가전 제품"));
        mExampleList.add(new DictionaryItem("appointment", "약속, 임명, 지명")); mExampleList.add(new DictionaryItem("appreciate", "좋게 보다, 고마워하다, 인식하다"));
        mExampleList.add(new DictionaryItem("appropriate", "알맞은, 도용하다, 책정하다")); mExampleList.add(new DictionaryItem("appropriation", "도용, 전용, 책정"));
        mExampleList.add(new DictionaryItem("arena", "경기장, 공연장, 무대")); mExampleList.add(new DictionaryItem("associate", "동료, 친구, 연상하다, 어울리다"));
        mExampleList.add(new DictionaryItem("associated with", "~와 관련된")); mExampleList.add(new DictionaryItem("athletics", "체육, 육상 경기"));
        mExampleList.add(new DictionaryItem("attention", "정성, 배려")); mExampleList.add(new DictionaryItem("attractively", "보기 좋게, 매력적으로"));
        mExampleList.add(new DictionaryItem("authority", "권한, 권위, 지휘권, 인가")); mExampleList.add(new DictionaryItem("authorization", "권한 부여, 허가, 허가증"));
        mExampleList.add(new DictionaryItem("authorized", "공인된, 인정받은, 권한을 받은")); mExampleList.add(new DictionaryItem("automotive", "자동차의"));
        mExampleList.add(new DictionaryItem("award-winning", "상을 받은")); mExampleList.add(new DictionaryItem("basement floor", "지하"));
        mExampleList.add(new DictionaryItem("be confronted with", "~에 직면하다")); mExampleList.add(new DictionaryItem("be loyal to", "~에 충실하다, 의리를 지키다"));
        mExampleList.add(new DictionaryItem("be packed with", "~로 가득하다, 꽉 들어차다")); mExampleList.add(new DictionaryItem("benefit", "혜택, 이익, 수당, 자선 행사"));
        mExampleList.add(new DictionaryItem("board of directiors", "이사회")); mExampleList.add(new DictionaryItem("bookkeeper", "회계 장부 담당자"));
        mExampleList.add(new DictionaryItem("bound", "꼭 ~할 것 같은, 얽매인, 해야 하는")); mExampleList.add(new DictionaryItem("burdensome", "부담스러운, 힘든"));
        mExampleList.add(new DictionaryItem("capable", "유능한, 능력 있는")); mExampleList.add(new DictionaryItem("causative", "원인이 되는, 야기시키는"));
        mExampleList.add(new DictionaryItem("certified", "보증된, 공인의, 면허증을 가진")); mExampleList.add(new DictionaryItem("certify", "증명하다, 보증하다"));
        mExampleList.add(new DictionaryItem("charitable", "자비로운, 너그러운, 자선의")); mExampleList.add(new DictionaryItem("chief executive", "최고 책임자"));
        mExampleList.add(new DictionaryItem("circulate", "순환하다, 유포하다")); mExampleList.add(new DictionaryItem("circumstance", "환경, 사정, 상황, 형편"));
        mExampleList.add(new DictionaryItem("civil service", "공무원")); mExampleList.add(new DictionaryItem("clarity", "명료성, 명확성, 선명도"));
        mExampleList.add(new DictionaryItem("clothing", "의류, 옷")); mExampleList.add(new DictionaryItem("coincide with", "~과 동시에 일어나다"));
        mExampleList.add(new DictionaryItem("collecting", "채집, 수집, 모금용의")); mExampleList.add(new DictionaryItem("comfort", "안락, 편안함, 위로, 편의 시설"));
        mExampleList.add(new DictionaryItem("committee", "위원회")); mExampleList.add(new DictionaryItem("commodity", "상품, 원자재, 농산물"));
        mExampleList.add(new DictionaryItem("commonplace", "흔한, 보통의, 진부한 말")); mExampleList.add(new DictionaryItem("compatible with", "~와 양립할 수 있는"));
        mExampleList.add(new DictionaryItem("competent", "능숙한, 만족할 만한, 권한이 있는")); mExampleList.add(new DictionaryItem("completed", "작성한, 완료된"));
        mExampleList.add(new DictionaryItem("compliancy", "준수, 따름")); mExampleList.add(new DictionaryItem("component", "구성요소, 부품"));
        mExampleList.add(new DictionaryItem("concluding", "종결의, 최종의, 끝맺는")); mExampleList.add(new DictionaryItem("conclusion", "판단, 결론, 결말, 체결"));
        mExampleList.add(new DictionaryItem("confidential", "기밀의, 비밀의, 은밀한")); mExampleList.add(new DictionaryItem("consecutively", "연속하여, 연이어"));
        mExampleList.add(new DictionaryItem("conservation", "보존, 보호, 관리")); mExampleList.add(new DictionaryItem("constraint", "억압, 제약, 제한, 통제"));
        mExampleList.add(new DictionaryItem("contentment", "만족(감), 흡족함")); mExampleList.add(new DictionaryItem("corporate", "기업의, 회사의, 조직의, 법인의"));
        mExampleList.add(new DictionaryItem("corporation", "기업, 회사, 조합, 법인")); mExampleList.add(new DictionaryItem("coverage", "보도, 범위, 보급"));
        mExampleList.add(new DictionaryItem("critically", "비평적으로, 혹평하여, 위태롭게")); mExampleList.add(new DictionaryItem("crucial", "매우 중요한, 필수적인"));
        mExampleList.add(new DictionaryItem("cuisine", "요리, 요리법")); mExampleList.add(new DictionaryItem("currency", "통화, 토용"));
        mExampleList.add(new DictionaryItem("debate", "토론, 토의, 논쟁, 논의하다")); mExampleList.add(new DictionaryItem("dedication", "전념, 헌신"));
        mExampleList.add(new DictionaryItem("delegate", "대표자, 위임하다, 뽑다")); mExampleList.add(new DictionaryItem("demanding", "힘든, 부담이 큰, 요구가 많은"));
        mExampleList.add(new DictionaryItem("demonstrate", "증거를 보여 주다, 발휘하다")); mExampleList.add(new DictionaryItem("depending on", "~에 따라, 따라서"));
        mExampleList.add(new DictionaryItem("deposit", "착수금, 보증금")); mExampleList.add(new DictionaryItem("depression", "우울증, 불황"));
        mExampleList.add(new DictionaryItem("detector", "감지기, 탐지기")); mExampleList.add(new DictionaryItem("deteriorating", "악화 중인, 악화되어 가고 있는"));
        mExampleList.add(new DictionaryItem("determine", "밝히다, 알아내다, 결정하다")); mExampleList.add(new DictionaryItem("devise", "창안하다, 고안하다, 장치"));
        mExampleList.add(new DictionaryItem("dietary supplement", "건강 보조 식품")); mExampleList.add(new DictionaryItem("difficulties", "말썽, 곤란"));
        mExampleList.add(new DictionaryItem("disburse", "지불하다, 지출하다, 분배하다")); mExampleList.add(new DictionaryItem("disclose", "발표하다, 공개하다"));
        mExampleList.add(new DictionaryItem("discourage", "막다, 의욕을 꺾다, 좌절시키다")); mExampleList.add(new DictionaryItem("dispatch", "보내다, 파견하다"));
        mExampleList.add(new DictionaryItem("dispute", "분쟁, 논쟁, 이의를 제기하다")); mExampleList.add(new DictionaryItem("divulge", "알려 주다, 누설하다"));
        mExampleList.add(new DictionaryItem("downswing", "하락, 위축")); mExampleList.add(new DictionaryItem("drafting", "기안(방법), 제도, 선발"));
        mExampleList.add(new DictionaryItem("draw up", "작성하다, 만들다")); mExampleList.add(new DictionaryItem("eager", "열성적인, 열렬한, 간절히 바라는"));
        mExampleList.add(new DictionaryItem("ecosystem", "생태계")); mExampleList.add(new DictionaryItem("eligibleness", "바람직함, 적격임"));
        mExampleList.add(new DictionaryItem("eliminate", "제거하다")); mExampleList.add(new DictionaryItem("embark", "착수하다, 승선하다"));
        mExampleList.add(new DictionaryItem("embassy", "대사관")); mExampleList.add(new DictionaryItem("encounter", "직면하다, 접하다"));
        mExampleList.add(new DictionaryItem("enrollee", "등록자, 가입자")); mExampleList.add(new DictionaryItem("enthusiasm", "의욕, 열광, 열의, 열광하는 대상"));
        mExampleList.add(new DictionaryItem("enthusiastic", "열성적인, 열렬한, 간절히 바라는")); mExampleList.add(new DictionaryItem("entitled A to B", "A에게 B의 자격을 주다"));
        mExampleList.add(new DictionaryItem("envelope", "봉투, 비닐봉투")); mExampleList.add(new DictionaryItem("equality", "평균, 균등"));
        mExampleList.add(new DictionaryItem("ethical", "윤리적인, 도덕적인")); mExampleList.add(new DictionaryItem("exaggerate", "과장하다"));
        mExampleList.add(new DictionaryItem("exceptional", "아주 우수한, 특출한")); mExampleList.add(new DictionaryItem("exclusive", "독점적인, 비개방적인, 배타적인"));
        mExampleList.add(new DictionaryItem("exert", "가하다, 행사하다, 분투하다")); mExampleList.add(new DictionaryItem("exhausting", "소모적인, 진을 빼는"));
        mExampleList.add(new DictionaryItem("exhaustion", "소모, 고갈")); mExampleList.add(new DictionaryItem("expansion", "확대, 확장, 팽창"));
        mExampleList.add(new DictionaryItem("expansive", "광활한, 광범위한, 포괄적인, 고가의")); mExampleList.add(new DictionaryItem("exposition", "전시회, 설명, 박람회"));
        mExampleList.add(new DictionaryItem("extraction", "뽑아냄, 추출")); mExampleList.add(new DictionaryItem("fairly", "상당히, 꽤"));
        mExampleList.add(new DictionaryItem("file a complaint", "항의를 제기하다")); mExampleList.add(new DictionaryItem("fill out", "기입하다, 작성하다"));
        mExampleList.add(new DictionaryItem("fixture", "경기, 설치물, 고정물")); mExampleList.add(new DictionaryItem("forbid", "~을 어렵게 하다, 금지하다"));
        mExampleList.add(new DictionaryItem("formerly", "이전에, 예전에")); mExampleList.add(new DictionaryItem("fortune", "재산, 부, 거금, 운수, 행운"));
        mExampleList.add(new DictionaryItem("freeze", "얼다, 얼리다, 동결")); mExampleList.add(new DictionaryItem("furnish A with B", "A에게 B를 제공하다"));
        mExampleList.add(new DictionaryItem("generate", "발생시키다, 만들어 내다")); mExampleList.add(new DictionaryItem("genuine", "진짜의, 진품의, 진품"));
        mExampleList.add(new DictionaryItem("get along with", "~와 잘 지내다")); mExampleList.add(new DictionaryItem("get stuck", "꼼짝 못하게 되다, 막히다"));
        mExampleList.add(new DictionaryItem("go on strike", "파업하다")); mExampleList.add(new DictionaryItem("halt", "멈추다, 중지시키다, 멈춤, 중단"));
        mExampleList.add(new DictionaryItem("handcraft", "수공예")); mExampleList.add(new DictionaryItem("hazardous", "위험한"));
        mExampleList.add(new DictionaryItem("hoist", "끌어(들어)올리다, 승강장치")); mExampleList.add(new DictionaryItem("horticulture", "원예, 원예학"));
        mExampleList.add(new DictionaryItem("house", "집, 식구들, 수용하다")); mExampleList.add(new DictionaryItem("identically", "꼭 같게, 동등하게"));
        mExampleList.add(new DictionaryItem("immediacy", "직접성, 신속성, 속도")); mExampleList.add(new DictionaryItem("immigration", "이민, 이주"));
        mExampleList.add(new DictionaryItem("imperative", "긴급한, 필수적인, 위엄 있는")); mExampleList.add(new DictionaryItem("implement", "시행하다, 도구"));
        mExampleList.add(new DictionaryItem("implementation", "실행, 이행, 완성, 성취")); mExampleList.add(new DictionaryItem("in general", "전반적으로, 대체로, 보통"));
        mExampleList.add(new DictionaryItem("in recognition of", "~을 인정하여")); mExampleList.add(new DictionaryItem("in regard of", "~에 관해서는"));
        mExampleList.add(new DictionaryItem("in the long run", "긴 안목으로 보면, 결국에, 대체로")); mExampleList.add(new DictionaryItem("inability", "무능, 불능, 할 수 없음"));
        mExampleList.add(new DictionaryItem("inaccuracy", "오류, 틀림")); mExampleList.add(new DictionaryItem("inadvertently", "무심코, 우연히, 부주의로"));
        mExampleList.add(new DictionaryItem("incomplete", "미완성의, 불충분한, 불완전한")); mExampleList.add(new DictionaryItem("inconvenience", "불편, 애로, 불편한 사람"));
        mExampleList.add(new DictionaryItem("incorporate", "포함하다, 병합하다, 설립하다")); mExampleList.add(new DictionaryItem("indicate", "보이다, 가리키다"));
        mExampleList.add(new DictionaryItem("information packet", "자료 묶음")); mExampleList.add(new DictionaryItem("infrastructure", "기반, 사회(공공) 기반 시설"));
        mExampleList.add(new DictionaryItem("inhabit", "살다, 서식하다")); mExampleList.add(new DictionaryItem("initiate", "시작하다, 개시하다"));
        mExampleList.add(new DictionaryItem("innovate", "혁신하다, 도입하다")); mExampleList.add(new DictionaryItem("inspiring", "영감을 주는"));
        mExampleList.add(new DictionaryItem("instability", "불안정")); mExampleList.add(new DictionaryItem("institute", "기관, 연구소, 도입하다, 시작하다"));
        mExampleList.add(new DictionaryItem("instruction", "교육, 훈련")); mExampleList.add(new DictionaryItem("intention", "의사, 의도, 목적"));
        mExampleList.add(new DictionaryItem("interpreter", "통역사, 해석자")); mExampleList.add(new DictionaryItem("intersection", "교차로"));
        mExampleList.add(new DictionaryItem("intervene", "개입하다, 끼어들다")); mExampleList.add(new DictionaryItem("intriguing", "아주 흥미로운"));
        mExampleList.add(new DictionaryItem("involvement", "개입, 관여")); mExampleList.add(new DictionaryItem("irreversible", "돌이킬 수 없는, 철회할 수 없는"));
        mExampleList.add(new DictionaryItem("keen", "예리한")); mExampleList.add(new DictionaryItem("kitchen utensil", "주방 기구"));
        mExampleList.add(new DictionaryItem("lackluster", "광택이 없는, 혼탁한, 신통치 않은")); mExampleList.add(new DictionaryItem("lasting", "영속적인, 지속적인"));
        mExampleList.add(new DictionaryItem("layoff", "일시(정리)해고, 강제 해고")); mExampleList.add(new DictionaryItem("legalize", "적법화하다, 합법화하다"));
        mExampleList.add(new DictionaryItem("legally", "합법(법률)적으로, 법률상")); mExampleList.add(new DictionaryItem("likelihood", "있음직한, 가능성"));
        mExampleList.add(new DictionaryItem("living standard", "생활 수준")); mExampleList.add(new DictionaryItem("loyalty", "성실, 충실, 충성심"));
        mExampleList.add(new DictionaryItem("lucrative", "수익성이 좋은")); mExampleList.add(new DictionaryItem("make sense", "의미가 통하다, 타당하다"));
        mExampleList.add(new DictionaryItem("marvelous", "훌륭한, 놀라운, 기적적인")); mExampleList.add(new DictionaryItem("matter", "문제, 물질, 상황, 사정"));
        mExampleList.add(new DictionaryItem("meet the requirements", "조건을 충족시키다")); mExampleList.add(new DictionaryItem("moderate", "사회를 보다, 절제하다, 중간의"));
        mExampleList.add(new DictionaryItem("morale", "사기, 의욕")); mExampleList.add(new DictionaryItem("mortgage", "대출, 융자, 저당 잡히다"));
        mExampleList.add(new DictionaryItem("mostly", "주로, 일반적으로")); mExampleList.add(new DictionaryItem("necessary", "필요한, 필연적인"));
        mExampleList.add(new DictionaryItem("negotiate", "성사시키다, 협상하다, 타결하다")); mExampleList.add(new DictionaryItem("negotiator", "협상자, 교섭자"));
        mExampleList.add(new DictionaryItem("nonprofit", "비영리의, 비영리 단체")); mExampleList.add(new DictionaryItem("offense", "공격적인, 무례, 불쾌한 것"));
        mExampleList.add(new DictionaryItem("operational", "운영상의")); mExampleList.add(new DictionaryItem("operator", "운영자, 경영자"));
        mExampleList.add(new DictionaryItem("organize", "조직하다, 정리하다, 체계화하다")); mExampleList.add(new DictionaryItem("originality", "독창성"));
        mExampleList.add(new DictionaryItem("orphanage", "고아원")); mExampleList.add(new DictionaryItem("outdated", "시대에 뒤쳐진, 구식의"));
        mExampleList.add(new DictionaryItem("outline", "개요, 윤곽을 보여 주다")); mExampleList.add(new DictionaryItem("outreach", "봉사 활동, 지원 활동"));
        mExampleList.add(new DictionaryItem("overall", "종합적으로, 전반적으로, 대체로")); mExampleList.add(new DictionaryItem("overrun", "급속히 퍼지다, 가득 차다"));
        mExampleList.add(new DictionaryItem("overtaking", "추월, 앞지르기")); mExampleList.add(new DictionaryItem("participant", "참가자, 참여자"));
        mExampleList.add(new DictionaryItem("patron", "후원자, 홍보대사, 고객")); mExampleList.add(new DictionaryItem("payroll", "임금대장, 급여 지급"));
        mExampleList.add(new DictionaryItem("pension", "연금, 생활 보조금, 수당")); mExampleList.add(new DictionaryItem("perceive", "알아차리다, 인지하다, 여기다"));
        mExampleList.add(new DictionaryItem("perfection", "완벽, 완성")); mExampleList.add(new DictionaryItem("permanent", "영구적인, 정규직의, 영원한"));
        mExampleList.add(new DictionaryItem("personalize", "표시하다, 맞추다, 개인화하다")); mExampleList.add(new DictionaryItem("personally", "개인적으로, 직접"));
        mExampleList.add(new DictionaryItem("physician", "의사, 의료진")); mExampleList.add(new DictionaryItem("plagiarism", "표절"));
        mExampleList.add(new DictionaryItem("power outage", "정전, 송전 정지")); mExampleList.add(new DictionaryItem("precipitation", "강수, 강수량, 침전"));
        mExampleList.add(new DictionaryItem("precisely", "바로, 정확히, 정확하게")); mExampleList.add(new DictionaryItem("prescription", "처방, 처방전"));
        mExampleList.add(new DictionaryItem("prime", "주된, 주요한, 최고의, 전성기")); mExampleList.add(new DictionaryItem("private", "개인 소유의, 사적인, 전용의"));
        mExampleList.add(new DictionaryItem("progressive", "진보적인, 점진적인, 진행되는")); mExampleList.add(new DictionaryItem("promptness", "재빠름, 신속, 민첩성"));
        mExampleList.add(new DictionaryItem("proof", "증거(물), 증명(서), 입증")); mExampleList.add(new DictionaryItem("proportion", "부분, 비율, 비, 균형"));
        mExampleList.add(new DictionaryItem("prospective", "차기의. 장래의, 유망한")); mExampleList.add(new DictionaryItem("provided", "만약 ~라면"));
        mExampleList.add(new DictionaryItem("publicist", "홍보 담당자")); mExampleList.add(new DictionaryItem("push", "밀다, 노력, 분발, 추진"));
        mExampleList.add(new DictionaryItem("quota", "할당량, 한도(량), 몫")); mExampleList.add(new DictionaryItem("range from A to B", "A에게 B까지 이르다"));
        mExampleList.add(new DictionaryItem("raw meterial", "원자재, 원료")); mExampleList.add(new DictionaryItem("real estate agent", "부동산 중개인"));
        mExampleList.add(new DictionaryItem("reassure", "안심시키다")); mExampleList.add(new DictionaryItem("recognition", "인식, 인정, 승인, 표창"));
        mExampleList.add(new DictionaryItem("reference", "참고, 참조")); mExampleList.add(new DictionaryItem("refinance", "재정을 재건하다, 차환하다"));
        mExampleList.add(new DictionaryItem("reform", "개선하다, 교화시키다, 교화하다")); mExampleList.add(new DictionaryItem("refurbish", "새로 단장하다, 갈다"));
        mExampleList.add(new DictionaryItem("refute", "반박하다, 부인하다")); mExampleList.add(new DictionaryItem("regardful", "주의 깊은, 유의하는, 용의주도한"));
        mExampleList.add(new DictionaryItem("regimen", "꾸준하고 엄한 훈련, 식이 요법")); mExampleList.add(new DictionaryItem("regional office", "지사, 지방 관청"));
        mExampleList.add(new DictionaryItem("registered", "등록된, 공인된")); mExampleList.add(new DictionaryItem("registration form", "신청서, 등기 용지"));
        mExampleList.add(new DictionaryItem("registrant", "등록자")); mExampleList.add(new DictionaryItem("regulation", "규정, 규제, 통제, 단속"));
        mExampleList.add(new DictionaryItem("reimbursement", "상환, 변제, 배상, 갚음")); mExampleList.add(new DictionaryItem("reliability", "신뢰도, 확실성"));
        mExampleList.add(new DictionaryItem("relieved", "안도하는, 다행으로 여기는")); mExampleList.add(new DictionaryItem("remarkably", "두드러지게, 현저하게"));
        mExampleList.add(new DictionaryItem("remind", "상기시키다, 다시 한번 말해 주다")); mExampleList.add(new DictionaryItem("repeatedly", "되풀이하여, 여러 차례"));
        mExampleList.add(new DictionaryItem("reportable", "보고 가치가 있는, 보고할 수 있는")); mExampleList.add(new DictionaryItem("reproduce", "복사하다, 다시 만들어 내다"));
        mExampleList.add(new DictionaryItem("reproduction", "생식, 번식, 복제품, 복제")); mExampleList.add(new DictionaryItem("residence", "주택, 거주지"));
        mExampleList.add(new DictionaryItem("resignation", "사직, 사임, 사직서")); mExampleList.add(new DictionaryItem("respondent", "응답자"));
        mExampleList.add(new DictionaryItem("restructuring", "기업 혁신 전략, 구조조정")); mExampleList.add(new DictionaryItem("retirement", "연금, 퇴직"));
        mExampleList.add(new DictionaryItem("revealing", "(흥미로운 사실을) 드러내는")); mExampleList.add(new DictionaryItem("rewarding", "보람 있는, 돈을 많이 받는"));
        mExampleList.add(new DictionaryItem("run through", "~을 관통하다, 퍼지다, 넘치다")); mExampleList.add(new DictionaryItem("sales representative", "영업 담당자"));
        mExampleList.add(new DictionaryItem("satisfaction", "만족, 충족")); mExampleList.add(new DictionaryItem("scenery", "경치, 풍경, 무대"));
        mExampleList.add(new DictionaryItem("senior", "고위의, 성인을 위한, 선배")); mExampleList.add(new DictionaryItem("settlement", "합의, 해결, 정착"));
        mExampleList.add(new DictionaryItem("severance package", "퇴직금")); mExampleList.add(new DictionaryItem("shareholder", "주주"));
        mExampleList.add(new DictionaryItem("shelter", "거주지, 피신(대피), 피난처")); mExampleList.add(new DictionaryItem("shortfall", "부족(량), 부족액"));
        mExampleList.add(new DictionaryItem("simplicity", "간단함, 평이함, 소박함")); mExampleList.add(new DictionaryItem("sizable", "꽤 큰, 상당한 크기의"));
        mExampleList.add(new DictionaryItem("specialization", "전문화, 특수화, 전문 분야")); mExampleList.add(new DictionaryItem("specialized", "전문적인, 전문화된"));
        mExampleList.add(new DictionaryItem("species", "종")); mExampleList.add(new DictionaryItem("specifics", "세부사항, 구체적인"));
        mExampleList.add(new DictionaryItem("specify", "(구체적으로) 명시하다")); mExampleList.add(new DictionaryItem("spending", "소비, 지출"));
        mExampleList.add(new DictionaryItem("spring up", "갑자기 생겨나다, 생기다")); mExampleList.add(new DictionaryItem("stabilize", "안정되다, 안정시키다, 고정되다"));
        mExampleList.add(new DictionaryItem("standing", "고정적인, 서서 하는, 지위, 평판")); mExampleList.add(new DictionaryItem("stationery store", "문구점"));
        mExampleList.add(new DictionaryItem("steadily", "착실하게, 꾸준하게, 끊임없이")); mExampleList.add(new DictionaryItem("stimulate", "자극하다, 흥미를 불러일으키다"));
        mExampleList.add(new DictionaryItem("strategic", "전략의, 전략적인")); mExampleList.add(new DictionaryItem("strategy", "계획, 전략"));
        mExampleList.add(new DictionaryItem("strengthen", "강화하다, 더 튼튼해지다")); mExampleList.add(new DictionaryItem("strike", "치다, 때리다, 파업"));
        mExampleList.add(new DictionaryItem("stun", "기절시키다, 큰 감동을 주다")); mExampleList.add(new DictionaryItem("subjective", "주관적인, 마음속에 존재하는"));
        mExampleList.add(new DictionaryItem("substandard", "표준 이하의, 열악한")); mExampleList.add(new DictionaryItem("suddenly", "갑자기, 돌연히, 급작스럽게"));
        mExampleList.add(new DictionaryItem("suitable", "적합한, 적절한, 알맞은")); mExampleList.add(new DictionaryItem("supplemental", "보충의, 부록의, 추가"));
        mExampleList.add(new DictionaryItem("supplementary", "추가의, 보충의")); mExampleList.add(new DictionaryItem("surveyor", "측량사, 감정인, 감독관"));
        mExampleList.add(new DictionaryItem("switch over", "바꾸다, 돌리다, 전환, 변환")); mExampleList.add(new DictionaryItem("terminate", "끝나다, 종료되다"));
        mExampleList.add(new DictionaryItem("termination", "종료")); mExampleList.add(new DictionaryItem("the elderly", "노인들"));
        mExampleList.add(new DictionaryItem("the underprivileged", "불우한 사람들")); mExampleList.add(new DictionaryItem("translation", "통역, 번역, 번역문"));
        mExampleList.add(new DictionaryItem("transmission", "전염, 송전, 전송, 방송")); mExampleList.add(new DictionaryItem("transmit", "발신하다, 전달하다"));
        mExampleList.add(new DictionaryItem("trustworthy", "믿을 만한, 신뢰할 수 있는")); mExampleList.add(new DictionaryItem("tuition", "수업, 교습, 등록금, 수업료"));
        mExampleList.add(new DictionaryItem("unanimously", "만장일치로")); mExampleList.add(new DictionaryItem("undercover", "비밀의, 위장 근무의"));
        mExampleList.add(new DictionaryItem("unmatched", "상대가 없는, 타의 추종을 불허하는")); mExampleList.add(new DictionaryItem("unsound", "부적절한, 견고하지 못한"));
        mExampleList.add(new DictionaryItem("unwilling", "꺼리는, 싫어하는, 본의 아닌")); mExampleList.add(new DictionaryItem("up-to-date", "최신의, 최근의"));
        mExampleList.add(new DictionaryItem("valuables", "귀중품")); mExampleList.add(new DictionaryItem("vegetation", "초목, 식물"));
        mExampleList.add(new DictionaryItem("verify", "확인하다, 입증하다, 진리, 진실")); mExampleList.add(new DictionaryItem("vice president", "부통령, 부사장"));
        mExampleList.add(new DictionaryItem("when it comes to", "~에 관해서는, ~에 관한 한")); mExampleList.add(new DictionaryItem("whereas", "반면에"));
        mExampleList.add(new DictionaryItem("within easy distance", "가까운 거리에")); mExampleList.add(new DictionaryItem("world-renowned", "세계적으로 유명한"));

    }


    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new DictionaryAdapter(mExampleList);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), new LinearLayoutManager(this).getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}