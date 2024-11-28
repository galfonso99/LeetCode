class Trie {
	isEnd: boolean;
    children: Trie[];
    constructor() {
		this.children = new Array(26);
        this.isEnd = false;
    }

    insert(word: string): void { this._insert(word, 0);}
	private _insert(word: string, ind: number) {
		if (ind >= word.length) return;
		const i: number = word.charCodeAt(ind) - "a".charCodeAt(0);
		if (this.children[i] == null) this.children[i] = new Trie();
		if (ind === word.length - 1) this.children[i].isEnd = true;
		this.children[i]._insert(word, ind+1);
	}

    search(word: string): boolean { return this._search(word, 0); }
	private _search(word: string, ind: number): boolean {
		if (ind >= word.length) return false;
		const trie: Trie = this.children[ word.charCodeAt(ind) - "a".charCodeAt(0) ];
		if (trie == null) return false;
		if (ind === word.length - 1 && trie.isEnd) return true;
		return trie._search(word, ind+1);
	}

    startsWith(prefix: string): boolean { return this._startsWith(prefix, 0); }
	private _startsWith(prefix: string, ind: number): boolean {
		if (ind >= prefix.length) return false;
		const trie: Trie = this.children[ prefix.charCodeAt(ind) - "a".charCodeAt(0) ];
		if (trie == null) return false;
		if (ind === prefix.length - 1) return true;
		return trie._startsWith(prefix, ind+1);
	}
}

