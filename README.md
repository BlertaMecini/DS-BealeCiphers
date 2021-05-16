# Siguria e të dhënave Projekti 1
## Beale Ciphers (Beale Papers)
Ky projekt është projekti i parë i realizuar në kuadër të lëndës siguria e të dhënave nga grupi 33 i studentëve të vitit të dytë në FIEK. Në kuadër të këtij projekti është implementuar Beale Ciphers i cili shfrytëzon një tekst dokument si libër.

## Historia
Beale Ciphers (ose Beale Papers) janë një tërësi prej tre tekstesh shifrore, njëra prej të cilave pretendohet se tregon vendndodhjen ku është groposur një thesar prej ari, argjendi dhe bizhuterish që vlerësohet të jetë me vlerë mbi 43 milion dollarë amerikanë. Duke përfshirë tre ciphertekste, teksti i parë (i pazgjidhur) përshkruan vendndodhjen, i dyti (i zgjidhur) përshkruan  përmbajtjen e thesarit, dhe i treti (i pazgjidhur) rendit emrat e pronarëve të thesarit dhe të afërmve të tyre.Historia e tre teksteve shifrore buron nga një broshurë e vitit 1885 që përshkruan thesarin duke u groposur nga një burrë i quajtur Thomas J. Beale në një vend të fshehtë në Bedford County, Virginia, në vitin 1820. Beale ia besoi një kuti që përmbante mesazhet e koduara një njeriu me emrin Robert Morriss dhe më pas u zhduk, për të mos u parë më kurrë. Sipas historisë, ai hapi kutinë 23 vite më vonë, dhe dekada më pas, ia dha të tre ciphertekstet një shoku para se të vdiste.Miku atëherë kaloi njëzet vitet e ardhshme të jetës së tij duke u përpjekur të deshifronte mesazhet dhe ishte në gjendje të zgjidhte vetëm njërën prej tyre që jepte detaje të thesarit të groposur dhe vendndodhjen e përgjithshme të thesarit. Më pas ai botoi të tre ciphertekstet në një broshurë e cila u reklamua për shitje në vitin 1880.Që nga botimi i pamfletit, janë bërë një numër përpjekjesh për të deshifruar dy tekstet e mbetura dhe për të gjetur thesarin, por të gjitha përpjekjet ishin të kota.

## Algoritmi 
Algoritmi i Beale përdor një variant të book cipher. E zgjedhim një tekst të gjatë si çelës, numërojmë secilën nga fjalët në tekst në mënyrë sekuenciale, duke filluar nga 1. Për enkriptim të plaintekstit krahasojmë secilën shkronjë të tij me shkronjën e parë të secilës fjalë të tekstit. Aty ku përputhen shkronjat e marrim numrin që i përket asaj fjale. Për shembull, nëse teksti qelës është "now is the time" dhe plainteksti është "tin", atëherë ose (3 2 1) ose (4 2 1) janë enkriptime të vlefshme.Nëse teksti çelës është i gjatë, do të ketë shumë duplikate, siç pamë me shkronjën "t",  prandaj kur enkriptojmë e marrim shkronjën e njëjtë në mënyrë të rëndomtë, gjë që e bënë algoritmin më të sigurtë. Sa i përket dekriptimit krahasojmë numrat e dhënë në ciphertekst me secilin numër të fjalëve të dokumentit, dhe ku kemi përputhje të numrave e marrim shkronjën e parë të asaj fjale të tekstit.

Pjesa e shkëputur e kodit në të cilën demonstrohet enkriptimi.
![image](https://user-images.githubusercontent.com/75573960/118408776-4a667180-b687-11eb-95ab-08c92a9b6f09.png)

Pjesa e shkëputur e kodit në të cilën demonstrohet dekriptimi.
![image](https://user-images.githubusercontent.com/75573960/118408869-c1036f00-b687-11eb-8583-184f5f211232.png)

## Kompajllimi  me Command Prompt
Kompajllimi mund të bëhet përmes komandës 'javac' e më pas t'i jepet path-i ku e kemi të ruajtur kodin burimor si dhe '-d' për të krijuar folderin ku do të ruhet klasa që krijohet me rastin e kompajllimit.Pasi të kompajllohet mund ta ekzekutojmë programin përmes komandës 'java' në këtë rast ia japim path-in e plotë dhe argumentin(encrypt ose decrypt që janë case insensitive).Varësisht nga argumenti i zgjedhur duhet t'i jepet ose plainteksti ose cipherteksti.

![image](https://user-images.githubusercontent.com/75573960/118409035-c9a87500-b688-11eb-8147-4623d013cf60.png)

Nëse jepet ndonjë argument tjetër përveq encrypt/decrypt do të shfaqet mesazhi si më poshtë:
![image](https://user-images.githubusercontent.com/75573960/118409472-ee055100-b68a-11eb-97a7-542444567897.png)

## Validimi dhe testimi
Në kuadër të këtij programi janë realizuar edhe disa validime si psh në pjesën e enkriptimit nuk mund të enkriptojmë ndonjë karakter special ose vetëm hapësira, ndërsa te dekriptimi nuk mund të dekriptojmë karaktere tjera përveq numrave.

Pjesa e validimit te enkriptimi:

![image](https://user-images.githubusercontent.com/75573960/118409668-e7c3a480-b68b-11eb-87cb-85100c8c416c.png)

Pjesa e validimit te dekriptimi:

![image](https://user-images.githubusercontent.com/75573960/118409685-0b86ea80-b68c-11eb-969b-df9b8dc6efea.png)

Testimi:

![image](https://user-images.githubusercontent.com/75573960/118409728-2fe2c700-b68c-11eb-87c4-a97cdabc0cfe.png)

## Desktop app
Ky program është realizuar edhe si desktop aplikacion me një GUI të thjeshtë duke përdorur javafx.

Ky GUI duket si në fotot më poshtë:

![image](https://user-images.githubusercontent.com/75573960/118409932-2dcd3800-b68d-11eb-9eea-254f8cdd8d03.png)
![image](https://user-images.githubusercontent.com/75573960/118409954-55240500-b68d-11eb-9d9b-ee3f82115aee.png)

Paraqitja e mesazhit të gabimit nëse jepet hyrje jovalide në pjesën përkatëse:

![image](https://user-images.githubusercontent.com/75573960/118410115-235f6e00-b68e-11eb-9ae7-aaa3c6cbfa0b.png)
![image](https://user-images.githubusercontent.com/75573960/118410132-3a05c500-b68e-11eb-9f29-b50de9495608.png)

### Veglat e përdoruara
Realizimi i këtij projekti është bërë në gjuhën programuese Java. 

### Kontribuesit
* [Blerta Mecini](https://github.com/BlertaMecini) 
* [Diana Beqiri](https://github.com/DianaBeqiri) 
* [Diare Daqi](https://github.com/DiareDaqi1) 

<a href = "https://github.com/BlertaMecini/DS-BealeCiphers/graphs/contributors">
<img src = "https://contrib.rocks/image?repo=BlertaMecini/DS-BealeCiphers"/>
</a>


### Licensa 
Ky projekt është i licensuar nën licensën MIT - shikoni skedarin [LICENSE.md](LICENSE.md) për detaje
