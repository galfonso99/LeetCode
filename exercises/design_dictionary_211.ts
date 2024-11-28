// Optimal recursive Solution
class WordDictionary {
	children: WordDictionary[]
	isEnd: boolean = false
    constructor() {
		this.children = new Array(26);
    }

    addWord(word: string): void {
		let curr: WordDictionary = this
		for (let i = 0; i < word.length; i++) {
			const ind = word.charCodeAt(i) - 'a'.charCodeAt(0);
			if (curr.children[ind] == null) curr.children[ind] = new WordDictionary();
			curr = curr.children[ind]
		}
		curr.isEnd = true
    }

    search(word: string): boolean {
		return this._search(word, 0);
    }
	private _search(word: string, start: number): boolean {
		let curr: WordDictionary = this!
		for (let i = start; i < word.length; i++) {
			const ind = word.charCodeAt(i) - 'a'.charCodeAt(0)
			if (word[i] === ".") {
				for (const c of curr.children) {
					if (c != null && c._search(word, i+1)) return true
				}
                return false
			}
			if (curr.children[ind] == null) return false
			curr = curr.children[ind]
		}
		return curr != null && curr.isEnd
	}
}

